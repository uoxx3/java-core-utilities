package uoxx3.wrapper;

import org.jetbrains.annotations.NotNull;

public interface UNumberWrapper<T extends Number, W extends UNumberWrapper<?, ?>> {
	
	/**
	 * Checks if the array content is equal to the specified double value within a default tolerance.
	 *
	 * @param other The double value to compare against.
	 * @return true if the array content is equal to the specified double value within the default tolerance, false otherwise.
	 */
	boolean contentEquals(double other);
	
	/**
	 * Checks if the array content is equal to the specified double value within the specified tolerance.
	 *
	 * @param other     The double value to compare against.
	 * @param tolerance The tolerance for the comparison.
	 * @return true if the array content is equal to the specified double value within the specified tolerance, false otherwise.
	 */
	boolean contentEquals(double other, double tolerance);
	
	/**
	 * Checks if the array content is equal to the specified long value.
	 *
	 * @param other The long value to compare against.
	 * @return true if the array content is equal to the specified long value, false otherwise.
	 */
	boolean contentEquals(long other);
	
	/**
	 * Checks if the array content is equal to the content of the specified UByteWrapper.
	 *
	 * @param other The UByteWrapper to compare against.
	 * @return true if the array content is equal to the content of the specified UByteWrapper, false otherwise.
	 */
	boolean contentEquals(@NotNull W other);
	
	/**
	 * Converts a primitive wrapper to one of type object
	 *
	 * @return a new wrapper object with the contents of the main wrapper
	 */
	@NotNull UObjectWrapper<T> toObjectWrapper();
	
}
