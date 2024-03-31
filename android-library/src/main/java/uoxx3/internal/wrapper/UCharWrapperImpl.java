package uoxx3.internal.wrapper;

import androidx.annotation.NonNull;
import uoxx3.functional.CharFunction;
import uoxx3.functional.consumer.CharConsumer;
import uoxx3.wrapper.UCharWrapper;
import uoxx3.wrapper.UObjectWrapper;

public final class UCharWrapperImpl implements UCharWrapper {
	
	/* -----------------------------------------------------
	 * Properties
	 * ----------------------------------------------------- */
	
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
	public @NonNull UCharWrapper also(@NonNull CharConsumer consumer) {
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
	public @NonNull UCharWrapper apply(@NonNull CharOnlyFunction function) {
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
	public @NonNull <R> UObjectWrapper<R> apply(@NonNull CharFunction<R> function) {
		return new UObjectWrapperImpl<>(
			function.apply(getAsChar())
		);
	}
	
	/**
	 * Creates a deep copy of the object.
	 *
	 * @return A deep copy of the object.
	 */
	@NonNull
	@Override
	public UCharWrapper copy() {
		return apply((char c) -> c);
	}
	
	/**
	 * Gets a char value.
	 *
	 * @return a char value
	 */
	@Override
	public char getAsChar() {
		return value;
	}
	
	/**
	 * Converts a primitive wrapper to one of type object
	 *
	 * @return a new wrapper object with the contents of the main wrapper
	 */
	@Override
	public @NonNull UObjectWrapper<Character> toObjectWrapper() {
		return apply((char character) -> (Character) character);
	}
	
}
