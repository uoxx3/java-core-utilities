package uoxx3.internal.wrapper;

import org.jetbrains.annotations.NotNull;
import uoxx3.functional.CharFunction;
import uoxx3.functional.consumer.CharConsumer;
import uoxx3.wrapper.UCharWrapper;
import uoxx3.wrapper.UObjectWrapper;

public final class UCharWrapperImpl implements UCharWrapper {
	
	/* -----------------------------------------------------
	 * Properties
	 * ----------------------------------------------------- */
	
	/**
	 * The lock object for synchronization.
	 */
	private final Object lock = new Object();
	
	/**
	 * The wrapped primitive.
	 */
	private final char value;
	
	/* -----------------------------------------------------
	 * Constructors
	 * ----------------------------------------------------- */
	
	/**
	 * Constructs a new UObjectWrapperImpl with the specified content.
	 *
	 * @param content the content to wrap
	 */
	public UCharWrapperImpl(char content) {
		value = content;
	}
	
	/**
	 * Constructs a new UObjectWrapperImpl with no content.
	 */
	public UCharWrapperImpl() {
		this('\u0000');
	}
	
	/* -----------------------------------------------------
	 * Methods
	 * ----------------------------------------------------- */
	
	/**
	 * Performs the given action on the wrapped char value and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@Override
	public @NotNull UCharWrapper also(@NotNull CharConsumer consumer) {
		consumer.accept(getAsChar());
		return this;
	}
	
	/**
	 * Applies the given function to the wrapped character value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UCharWrapper containing the result of the function
	 */
	@Override
	public @NotNull UCharWrapper apply(@NotNull CharOnlyFunction function) {
		return new UCharWrapperImpl(
			function.apply(getAsChar())
		);
	}
	
	/**
	 * Applies the given function to the wrapped char value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UObjectWrapper containing the result of the function
	 */
	@Override
	public @NotNull <R> UObjectWrapper<R> apply(@NotNull CharFunction<R> function) {
		return new UObjectWrapperImpl<>(
			function.apply(getAsChar())
		);
	}
	
	/**
	 * Gets a char value.
	 *
	 * @return a char value
	 */
	@Override
	public char getAsChar() {
		synchronized (lock) {
			return value;
		}
	}
	
	/**
	 * Converts a primitive wrapper to one of type object
	 *
	 * @return a new wrapper object with the contents of the main wrapper
	 */
	@Override
	public @NotNull UObjectWrapper<Character> toObjectWrapper() {
		return apply((char character) -> (Character) character);
	}
	
}
