package uoxx3.internal;

public interface IUClassConstants {
	
	/* -----------------------------------------------------
	 * Primitive constants
	 * ----------------------------------------------------- */
	
	/**
	 * Map of primitive types to their corresponding Class objects.
	 */
	Class<?>[] CLASS_PRIMITIVE_TYPES_MAP = new Class[]{
		char.class, byte.class, short.class, int.class,
		long.class, float.class, double.class, void.class
	};
	
	/**
	 * Map of primitive wrapper types to their corresponding Class objects.
	 */
	Class<?>[] CLASS_PRIMITIVE_WRAPPER_TYPES_MAP = new Class[]{
		Character.class, Byte.class, Short.class, Integer.class,
		Long.class, Float.class, Double.class, Void.class
	};
	
	/**
	 * Map of primitive array types to their corresponding Class objects.
	 */
	Class<?>[] CLASS_PRIMITIVE_ARRAY_TYPES_MAP = new Class[]{
		char[].class, byte[].class, short[].class, int[].class,
		long[].class, float[].class, double[].class
	};
	
}
