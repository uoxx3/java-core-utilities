package uoxx3.wrapper;

import org.jetbrains.annotations.NotNull;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;

/**
 * A wrapper interface for integer values.
 */
public interface UIntegerWrapper extends IntSupplier, UNumberWrapper<Integer, UIntegerWrapper> {
	
	/**
	 * Performs the given action on the wrapped integer value and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@NotNull UIntegerWrapper also(@NotNull IntConsumer consumer);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param <R>      the type of the result
	 * @param function the function to apply
	 * @return a new UObjectWrapper containing the result of the function
	 */
	<R> @NotNull UObjectWrapper<R> apply(@NotNull IntFunction<R> function);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UByteWrapper containing the result of the function
	 */
	@NotNull UByteWrapper apply(@NotNull UByteWrapper.ByteOnlyFunction function);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UShortWrapper containing the result of the function
	 */
	@NotNull UShortWrapper apply(@NotNull UShortWrapper.ShortOnlyFunction function);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UIntegerWrapper containing the result of the function
	 */
	@NotNull UIntegerWrapper apply(@NotNull IntOnlyFunction function);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new ULongWrapper containing the result of the function
	 */
	@NotNull ULongWrapper apply(@NotNull ULongWrapper.LongOnlyFunction function);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UFloatWrapper containing the result of the function
	 */
	@NotNull UFloatWrapper apply(@NotNull UFloatWrapper.FloatOnlyFunction function);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UFloatWrapper containing the result of the function
	 */
	@NotNull UDoubleWrapper apply(@NotNull UDoubleWrapper.DoubleOnlyFunction function);
	
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
		return Math.abs(getAsInt() - other) <= tolerance;
	}
	
	/**
	 * Checks if the array content is equal to the specified long value.
	 *
	 * @param other The long value to compare against.
	 * @return true if the array content is equal to the specified long value, false otherwise.
	 */
	default boolean contentEquals(long other) {
		return getAsInt() == other;
	}
	
	/**
	 * Checks if the array content is equal to the content of the specified UByteWrapper.
	 *
	 * @param other The UByteWrapper to compare against.
	 * @return true if the array content is equal to the content of the specified UByteWrapper, false otherwise.
	 */
	default boolean contentEquals(@NotNull UIntegerWrapper other) {
		return contentEquals(other.getAsInt());
	}
	
	/**
	 * Sets the maximum value for the wrapped integer value.
	 *
	 * @param value the maximum value
	 * @return this object
	 */
	@NotNull UIntegerWrapper max(int value);
	
	/**
	 * Sets the minimum value for the wrapped integer value.
	 *
	 * @param value the minimum value
	 * @return this object
	 */
	@NotNull UIntegerWrapper min(int value);
	
	
	/**
	 * A functional interface for functions that operate on integer values only.
	 */
	@FunctionalInterface
	interface IntOnlyFunction {
		
		/**
		 * Applies the function to the given integer value.
		 *
		 * @param value the integer value
		 * @return the result of the function
		 */
		int apply(int value);
		
	}
	
}