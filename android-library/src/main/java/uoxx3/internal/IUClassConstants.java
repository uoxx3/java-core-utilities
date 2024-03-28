package uoxx3.internal;

public interface IUClassConstants {
	
	/* -----------------------------------------------------
	 * Primitive constants
	 * ----------------------------------------------------- */
	
	Class<?>[] CLASS_PRIMITIVE_TYPES_MAP = new Class[]{
		char.class, byte.class, short.class, int.class,
		long.class, float.class, double.class, void.class
	};
	
	Class<?>[] CLASS_PRIMITIVE_WRAPPER_TYPES_MAP = new Class[]{
		Character.class, Byte.class, Short.class, Integer.class,
		Long.class, Float.class, Double.class, Void.class
	};
	
	Class<?>[] CLASS_PRIMITIVE_ARRAY_TYPES_MAP = new Class[]{
		char[].class, byte[].class, short[].class, int[].class,
		long[].class, float[].class, double[].class
	};
	
}
