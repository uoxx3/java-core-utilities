package uoxx3.wrapper;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import uoxx3.functional.supplier.ShortSupplier;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;

public interface UShortWrapper extends ShortSupplier {
	
	/**
	 * Sets the minimum value for the wrapped short value.
	 *
	 * @param value the minimum value
	 * @return this object
	 */
	@NonNull
	UShortWrapper min(@IntRange(from = Short.MIN_VALUE, to = 0) int value);
	
	/**
	 * Sets the maximum value for the wrapped short value.
	 *
	 * @param value the maximum value
	 * @return this object
	 */
	@NonNull
	UShortWrapper max(@IntRange(from = 0, to = Short.MAX_VALUE) int value);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param <R>      the type of the result
	 * @param function the function to apply
	 * @return a new UObjectWrapper containing the result of the function
	 */
	<R> @NonNull UObjectWrapper<R> apply(@NonNull IntFunction<R> function);
	
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
	UShortWrapper apply(@NonNull ShortOnlyFunction function);
	
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
	UFloatWrapper apply(@NonNull UFloatWrapper.FloatOnlyFunction function);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UFloatWrapper containing the result of the function
	 */
	@NonNull
	UDoubleWrapper apply(@NonNull UDoubleWrapper.DoubleOnlyFunction function);
	
	/**
	 * Performs the given action on the wrapped integer value and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@NonNull
	UShortWrapper also(@NonNull IntConsumer consumer);
	
	/**
	 * A functional interface for functions that operate on short values only.
	 */
	interface ShortOnlyFunction {
		
		/**
		 * Applies the function to the given short value.
		 *
		 * @param value the integer value
		 * @return the result of the function
		 */
		short apply(short value);
		
	}
	
}