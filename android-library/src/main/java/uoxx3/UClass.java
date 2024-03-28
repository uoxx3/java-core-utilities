package uoxx3;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import uoxx3.internal.IUClassConstants;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Stack;

public final class UClass {
	
	/**
	 * This class cannot be instantiated
	 */
	private UClass() {
		throw new Error("cannot be instantiated");
	}
	
	/* -----------------------------------------------------
	 * Primitive verification methods
	 * ----------------------------------------------------- */
	
	/**
	 * Checks if a given class is a primitive type, optionally including wrapper types.
	 *
	 * @param cls                 the class to check, not null
	 * @param includeWrapperTypes if true, also considers wrapper types as primitive types
	 * @return true if the class is a primitive type, false otherwise
	 */
	public static boolean isPrimitiveType(@NonNull Class<?> cls, boolean includeWrapperTypes) {
		UAssert.paramNotNull(cls, "Class<?> cls");
		boolean realPrimitive = cls.isPrimitive();
		if (!includeWrapperTypes) return realPrimitive;
		
		for (Class<?> primitiveType : IUClassConstants.CLASS_PRIMITIVE_TYPES_MAP) {
			if (cls == primitiveType || realPrimitive) return true;
		}
		
		return false;
	}
	
	/**
	 * Checks if a given class is a primitive type, optionally including wrapper types.
	 *
	 * @param cls the class to check, not null
	 * @return true if the class is a primitive type, false otherwise
	 */
	public static boolean isPrimitiveType(@NonNull Class<?> cls) {
		return isPrimitiveType(cls, false);
	}
	
	/* -----------------------------------------------------
	 * Dependency tree methods
	 * ----------------------------------------------------- */
	
	/**
	 * Builds a stack representing the inheritance tree of a class up to a specified depth.
	 *
	 * @param cls      the class to build the inheritance tree for, not null
	 * @param maxDepth the maximum depth to traverse the inheritance tree, -1 for unlimited depth
	 * @return a stack containing the classes in the inheritance tree, with the top being the input class
	 */
	@SuppressWarnings("DataFlowIssue")
	public static @NonNull Stack<Class<?>> classTree(
		@NonNull Class<?> cls,
		@IntRange(from = -1, to = Integer.MAX_VALUE) int maxDepth
	) {
		UAssert.paramNotNull(cls, "Class<?> cls");
		// The values are adjusted to be valid.
		maxDepth = Math.max(-1, maxDepth);
		
		// The information of the class and the current element is saved for
		// its next iteration within the inheritance tree.
		Stack<Class<?>> classStack = new Stack<>();
		int iteration = 0;
		
		// We perform an iteration until at least one of the conditions is fulfilled.
		// The conditions are the following:
		//    - Iterate class inheritance until finding the root super class java.lang.Object
		//    - Iterate until the "iteration" equals "maxDepth"
		//    - That the two previous ones are true at the same time
		do {
			// We push the current class onto the stack, because it also belongs to the
			// inheritance tree.
			classStack.push(cls);
			
			// We get the class that inherits the current class.
			cls = cls.getSuperclass();
			
			// We update the iteration turn only if it is less than the maximum number
			// of turns defined.
			if (iteration < maxDepth) iteration++;
		} while (cls != Objects.class && (maxDepth == -1 || iteration < maxDepth));
		
		// The stack is returned with the elements found or as far as the configuration
		// allowed them to be found.
		return classStack;
	}
	
	/**
	 * Builds a stack representing the inheritance tree of a class up to a specified depth.
	 *
	 * @param cls the class to build the inheritance tree for, not null
	 * @return a stack containing the classes in the inheritance tree, with the top being the input class
	 */
	public static @NonNull Stack<Class<?>> classTree(@NonNull Class<?> cls) {
		// When method "#classTree(Class, int)" its parameter "maxDepth" is defined as -1 it means
		// that the method will perform an iteration until the inheritance limit is reached.
		// This means that it will go through the entire inheritance tree of the class, and it will
		// depend on the type if it has more or fewer elements in inheritance.
		return classTree(cls, -1);
	}
	
	/* -----------------------------------------------------
	 * Vararg methods
	 * ----------------------------------------------------- */
	
	/**
	 * Returns an array of classes representing the types of the varargs objects, including null types.
	 *
	 * @param args the varargs objects, not null
	 * @return an array of classes representing the types of the varargs objects
	 */
	public static @NonNull Class<?>[] varargTypes(@NonNull Object... args) {
		UAssert.paramNotNull(args, "Object[] args");
		return Arrays.stream(args)
			.map(o -> o == null ? Object.class : o.getClass())
			.toArray(Class[]::new);
	}
	
	/**
	 * Returns an array of classes representing the types of the varargs objects, excluding null types.
	 *
	 * @param args the varargs objects, not null
	 * @return an array of classes representing the types of the varargs objects, excluding null types
	 */
	public static @NonNull Class<?>[] varargTypesNotNull(@NonNull Object... args) {
		UAssert.paramNotNull(args, "Object[] args");
		return Arrays.stream(args)
			.filter(Objects::nonNull)
			.map(Object::getClass)
			.toArray(Class[]::new);
	}
	
	/* -----------------------------------------------------
	 * Array individual type methods
	 * ----------------------------------------------------- */
	
	/**
	 * Returns the component type of one-dimensional array.
	 *
	 * @param array the array, not null
	 * @param <T>   the type of the array elements
	 * @return the component type of the array
	 */
	@SuppressWarnings("unchecked")
	public static <T> @NonNull Class<T> arrayComponentType(@NonNull T[] array) {
		UAssert.paramNotNull(array, "T[] array");
		return (Class<T>) multiDimensionalArrayComponentType(array);
	}
	
	/**
	 * Returns the component type of two-dimensional array.
	 *
	 * @param array the array, not null
	 * @param <T>   the type of the array elements
	 * @return the component type of the array
	 */
	@SuppressWarnings("unchecked")
	public static <T> @NonNull Class<T> arrayComponentType(@NonNull T[][] array) {
		UAssert.paramNotNull(array, "T[][] array");
		return (Class<T>) multiDimensionalArrayComponentType(array);
	}
	
	/**
	 * Returns the component type of multidimensional array.
	 *
	 * @param array the array, not null
	 * @return the component type of the array
	 */
	@SuppressWarnings("DataFlowIssue")
	public static @NonNull Class<?> multiDimensionalArrayComponentType(@NonNull Object array) {
		UAssert.paramNotNull(array, "Object array");
		UAssert.paramArrayType(array, "Object array");
		
		// For the other types we must reconstruct the full name of the class
		// and obtain it from the class loader.
		Class<?> arrayCls = array.getClass();
		String cleanClassName = arrayCls.getCanonicalName()
			.replaceAll("\\[]", "")
			.trim();
		
		Optional<Class<?>> primitiveFound = Arrays.stream(IUClassConstants.CLASS_PRIMITIVE_TYPES_MAP)
			.filter(it -> it.getCanonicalName().equals(cleanClassName))
			.findAny();
		if (primitiveFound.isPresent()) return primitiveFound.get();
		
		// We try to resolve the class name by dynamic loading. In theory, it should not
		// throw any loading cause, but Java requires exception handling, and it is done
		// so as not to have to handle it explicitly for each call.
		try {
			return Class.forName(cleanClassName, true, arrayCls.getClassLoader());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Cannot determine the type of the array.", e);
		}
	}
	
}
