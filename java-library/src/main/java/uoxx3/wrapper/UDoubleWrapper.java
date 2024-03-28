package uoxx3.wrapper;

import org.jetbrains.annotations.NotNull;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleSupplier;

public interface UDoubleWrapper extends DoubleSupplier {
	
	/**
	 * Sets the minimum value for the wrapped double value.
	 *
	 * @param value the minimum value
	 * @return this object
	 */
	@NotNull UDoubleWrapper min(double value);
	
	/**
	 * Sets the maximum value for the wrapped double value.
	 *
	 * @param value the maximum value
	 * @return this object
	 */
	@NotNull UDoubleWrapper max(double value);
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param <R>      the type of the result
	 * @param function the function to apply
	 * @return a new UObjectWrapper containing the result of the function
	 */
	<R> @NotNull UObjectWrapper<R> apply(@NotNull DoubleFunction<R> function);
	
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
	@NotNull UDoubleWrapper apply(@NotNull DoubleOnlyFunction function);
	
	/**
	 * Performs the given action on the wrapped integer value and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@NotNull UDoubleWrapper also(@NotNull DoubleConsumer consumer);
	
	/**
	 * A functional interface for functions that operate on double values only.
	 */
	@FunctionalInterface
	interface DoubleOnlyFunction {
		
		/**
		 * Applies the function to the given double value.
		 *
		 * @param value the double value
		 * @return the result of the function
		 */
		double apply(double value);
		
	}
	
}
