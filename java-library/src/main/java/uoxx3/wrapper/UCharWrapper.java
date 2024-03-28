package uoxx3.wrapper;

import org.jetbrains.annotations.NotNull;
import uoxx3.functional.CharFunction;
import uoxx3.functional.consumer.CharConsumer;
import uoxx3.functional.supplier.CharSupplier;

/**
 * A wrapper interface for char values.
 */
public interface UCharWrapper extends CharSupplier {
	
	/**
	 * Applies the given function to the wrapped char value and wraps the result.
	 *
	 * @param <R>      the type of the result
	 * @param function the function to apply
	 * @return a new UObjectWrapper containing the result of the function
	 */
	<R> @NotNull UObjectWrapper<R> apply(@NotNull CharFunction<R> function);
	
	/**
	 * Applies the given function to the wrapped character value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UCharWrapper containing the result of the function
	 */
	@NotNull UCharWrapper apply(@NotNull CharOnlyFunction function);
	
	/**
	 * Performs the given action on the wrapped char value and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@NotNull UCharWrapper also(@NotNull CharConsumer consumer);
	
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