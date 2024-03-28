package uoxx3.wrapper;

import androidx.annotation.NonNull;
import uoxx3.functional.supplier.FloatSupplier;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;

public interface UFloatWrapper extends FloatSupplier {
	
	/**
	 * Sets the minimum value for the wrapped float value.
	 *
	 * @param value the minimum value
	 * @return this object
	 */
	@NonNull
	UFloatWrapper min(float value);
	
	/**
	 * Sets the maximum value for the wrapped float value.
	 *
	 * @param value the maximum value
	 * @return this object
	 */
	@NonNull
	UFloatWrapper max(float value);
	
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
	 * Performs the given action on the wrapped integer value and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@NonNull
	UFloatWrapper also(@NonNull DoubleConsumer consumer);
	
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
