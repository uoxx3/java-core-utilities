package uoxx3.wrapper;

import org.jetbrains.annotations.NotNull;

import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongSupplier;

public interface ULongWrapper extends LongSupplier {
	
	/**
	 * Sets the minimum value for the wrapped long value.
	 *
	 * @param value the minimum value
	 * @return this object
	 */
	@NotNull ULongWrapper min(long value);
	
	/**
	 * Sets the maximum value for the wrapped long value.
	 *
	 * @param value the maximum value
	 * @return this object
	 */
	@NotNull ULongWrapper max(long value);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param <R>      the type of the result
	 * @param function the function to apply
	 * @return a new UObjectWrapper containing the result of the function
	 */
	<R> @NotNull UObjectWrapper<R> apply(@NotNull LongFunction<R> function);
	
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
	@NotNull UIntegerWrapper apply(@NotNull UIntegerWrapper.IntOnlyFunction function);
	
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
	 * Performs the given action on the wrapped integer value and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@NotNull ULongWrapper also(@NotNull LongConsumer consumer);
	
	/**
	 * A functional interface for functions that operate on short values only.
	 */
	interface LongOnlyFunction {
		
		/**
		 * Applies the function to the given long value.
		 *
		 * @param value the long value
		 * @return the result of the function
		 */
		long apply(long value);
		
	}
	
}
