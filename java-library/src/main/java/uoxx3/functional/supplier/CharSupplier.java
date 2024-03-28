package uoxx3.functional.supplier;

/**
 * A supplier of char values.
 */
@FunctionalInterface
public interface CharSupplier {
	
	/**
	 * Gets a char value.
	 *
	 * @return a char value
	 */
	char getAsChar();
	
}

