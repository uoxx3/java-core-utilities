package uoxx3.functional.supplier;

/**
 * A supplier of byte values.
 */
@FunctionalInterface
public interface ByteSupplier {
	
	/**
	 * Gets a byte value.
	 *
	 * @return a byte value
	 */
	byte getAsByte();
	
}

