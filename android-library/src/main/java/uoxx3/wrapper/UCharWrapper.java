package uoxx3.wrapper;

import androidx.annotation.NonNull;
import uoxx3.functional.CharFunction;
import uoxx3.functional.consumer.CharConsumer;
import uoxx3.functional.supplier.CharSupplier;

/**
 * A wrapper interface for char values.
 */
public interface UCharWrapper extends CharSupplier {
	
	/**
	 * Performs the given action on the wrapped char value and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@NonNull
	UCharWrapper also(@NonNull CharConsumer consumer);
	
	/**
	 * Applies the given function to the wrapped character value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UCharWrapper containing the result of the function
	 */
	@NonNull
	UCharWrapper apply(@NonNull CharOnlyFunction function);
	
	/**
	 * Applies the given function to the wrapped char value and wraps the result.
	 *
	 * @param <R>      the type of the result
	 * @param function the function to apply
	 * @return a new UObjectWrapper containing the result of the function
	 */
	<R> @NonNull UObjectWrapper<R> apply(@NonNull CharFunction<R> function);
	
	/**
	 * Checks if the array content is equal to the specified double value within a default tolerance.
	 *
	 * @param other The double value to compare against.
	 * @return true if the array content is equal to the specified double value within the default tolerance, false otherwise.
	 */
	default boolean contentEquals(char other) {
		return getAsChar() == other;
	}
	
	/**
	 * Checks if the array content is equal to the content of the specified UByteWrapper.
	 *
	 * @param other The UByteWrapper to compare against.
	 * @return true if the array content is equal to the content of the specified UByteWrapper, false otherwise.
	 */
	default boolean contentEquals(@NonNull UCharWrapper other) {
		return contentEquals(other.getAsChar());
	}
	
	/**
	 * Converts a primitive wrapper to one of type object
	 *
	 * @return a new wrapper object with the contents of the main wrapper
	 */
	@NonNull
	UObjectWrapper<Character> toObjectWrapper();
	
	/**
	 * A functional interface for functions that operate on double values only.
	 */
	@FunctionalInterface
	interface CharOnlyFunction {
		
		/**
		 * Applies the function to the given double value.
		 *
		 * @param value the double value
		 * @return the result of the function
		 */
		char apply(char value);
		
	}
	
}