package uoxx3.wrapper;

import androidx.annotation.NonNull;
import uoxx3.functional.supplier.FloatSupplier;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;

public interface UFloatWrapper extends FloatSupplier, UNumberWrapper<Float, UFloatWrapper> {
	
	/**
	 * Performs the given action on the wrapped integer value and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@NonNull
	UFloatWrapper also(@NonNull DoubleConsumer consumer);
	
	/**
	 * Applies the given function to the wrapped primitive value and wraps the result.
	 *
	 * @param <R>      the type of the result
	 * @param function the function to apply
	 * @return a new UObjectWrapper containing the result of the function
	 */
	<R> @NonNull UObjectWrapper<R> apply(@NonNull DoubleFunction<R> function);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UByteWrapper containing the result of the function
	 */
	@NonNull
	UByteWrapper apply(@NonNull UByteWrapper.ByteOnlyFunction function);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UShortWrapper containing the result of the function
	 */
	@NonNull
	UShortWrapper apply(@NonNull UShortWrapper.ShortOnlyFunction function);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UIntegerWrapper containing the result of the function
	 */
	@NonNull
	UIntegerWrapper apply(@NonNull UIntegerWrapper.IntOnlyFunction function);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new ULongWrapper containing the result of the function
	 */
	@NonNull
	ULongWrapper apply(@NonNull ULongWrapper.LongOnlyFunction function);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UFloatWrapper containing the result of the function
	 */
	@NonNull
	UFloatWrapper apply(@NonNull FloatOnlyFunction function);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UFloatWrapper containing the result of the function
	 */
	@NonNull
	UDoubleWrapper apply(@NonNull UDoubleWrapper.DoubleOnlyFunction function);
	
	/**
	 * Checks if the array content is equal to the specified double value within a default tolerance.
	 *
	 * @param other The double value to compare against.
	 * @return true if the array content is equal to the specified double value within the default tolerance, false otherwise.
	 */
	default boolean contentEquals(double other) {
		return contentEquals(other, UDoubleWrapper.EQUALS_TOLERANCE);
	}
	
	/**
	 * Checks if the array content is equal to the specified double value within the specified tolerance.
	 *
	 * @param other     The double value to compare against.
	 * @param tolerance The tolerance for the comparison.
	 * @return true if the array content is equal to the specified double value within the specified tolerance, false otherwise.
	 */
	default boolean contentEquals(double other, double tolerance) {
		return Math.abs(getAsFloat() - other) <= tolerance;
	}
	
	/**
	 * Checks if the array content is equal to the specified long value.
	 *
	 * @param other The long value to compare against.
	 * @return true if the array content is equal to the specified long value, false otherwise.
	 */
	@Override
	default boolean contentEquals(long other) {
		return contentEquals((double) other);
	}
	
	/**
	 * Checks if the array content is equal to the content of the specified UByteWrapper.
	 *
	 * @param other The UByteWrapper to compare against.
	 * @return true if the array content is equal to the content of the specified UByteWrapper, false otherwise.
	 */
	default boolean contentEquals(@NonNull UFloatWrapper other) {
		return contentEquals(other.getAsFloat());
	}
	
	/**
	 * Sets the maximum value for the wrapped float value.
	 *
	 * @param value the maximum value
	 * @return this object
	 */
	@NonNull
	UFloatWrapper max(float value);
	
	/**
	 * Sets the minimum value for the wrapped float value.
	 *
	 * @param value the minimum value
	 * @return this object
	 */
	@NonNull
	UFloatWrapper min(float value);
	
	/**
	 * A functional interface for functions that operate on float values only.
	 */
	@FunctionalInterface
	interface FloatOnlyFunction {
		
		/**
		 * Applies the function to the given float value.
		 *
		 * @param value the float value
		 * @return the result of the function
		 */
		float apply(float value);
		
	}
	
}
