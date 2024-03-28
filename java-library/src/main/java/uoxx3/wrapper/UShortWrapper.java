package uoxx3.wrapper;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;
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
	@NotNull UShortWrapper min(@Range(from = 0, to = Short.MIN_VALUE) int value);
	
	/**
	 * Sets the maximum value for the wrapped short value.
	 *
	 * @param value the maximum value
	 * @return this object
	 */
	@NotNull UShortWrapper max(@Range(from = 0, to = Short.MAX_VALUE) int value);
	
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
	@NotNull UShortWrapper apply(@NotNull ShortOnlyFunction function);
	
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
	@NotNull UShortWrapper also(@NotNull IntConsumer consumer);
	
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
