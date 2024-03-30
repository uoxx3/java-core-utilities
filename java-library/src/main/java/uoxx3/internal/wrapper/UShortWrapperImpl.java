package uoxx3.internal.wrapper;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;
import uoxx3.wrapper.*;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;

public final class UShortWrapperImpl implements UShortWrapper {
	
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
	private final short value;
	
	/**
	 * The minimum primitive value
	 */
	private short min;
	
	/**
	 * The maximum primitive value
	 */
	private short max;
	
	/* -----------------------------------------------------
	 * Constructors
	 * ----------------------------------------------------- */
	
	/**
	 * Constructs a new UObjectWrapperImpl with the specified content.
	 *
	 * @param content the content to wrap
	 */
	public UShortWrapperImpl(@Range(from = Short.MIN_VALUE, to = Short.MAX_VALUE) int content) {
		value = (short) content;
		min = Short.MIN_VALUE;
		max = Short.MAX_VALUE;
	}
	
	/**
	 * Constructs a new UObjectWrapperImpl with no content.
	 */
	public UShortWrapperImpl() {
		this(0);
	}
	
	/* -----------------------------------------------------
	 * Methods
	 * ----------------------------------------------------- */
	
	/**
	 * Performs the given action on the wrapped integer value and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@Override
	public @NotNull UShortWrapper also(@NotNull IntConsumer consumer) {
		consumer.accept(getAsShort());
		return this;
	}
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UObjectWrapper containing the result of the function
	 */
	@Override
	public @NotNull <R> UObjectWrapper<R> apply(@NotNull IntFunction<R> function) {
		return new UObjectWrapperImpl<>(
			function.apply(getAsShort())
		);
	}
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UByteWrapper containing the result of the function
	 */
	@Override
	public @NotNull UByteWrapper apply(UByteWrapper.@NotNull ByteOnlyFunction function) {
		return new UByteWrapperImpl(
			function.apply((byte) getAsShort())
		);
	}
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UShortWrapper containing the result of the function
	 */
	@Override
	public @NotNull UShortWrapper apply(@NotNull ShortOnlyFunction function) {
		return new UShortWrapperImpl(
			function.apply(getAsShort())
		);
	}
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UIntegerWrapper containing the result of the function
	 */
	@Override
	public @NotNull UIntegerWrapper apply(UIntegerWrapper.@NotNull IntOnlyFunction function) {
		return new UIntegerWrapperImpl(
			function.apply(getAsShort())
		);
	}
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new ULongWrapper containing the result of the function
	 */
	@Override
	public @NotNull ULongWrapper apply(ULongWrapper.@NotNull LongOnlyFunction function) {
		return new ULongWrapperImpl(
			function.apply(getAsShort())
		);
	}
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UFloatWrapper containing the result of the function
	 */
	@Override
	public @NotNull UFloatWrapper apply(UFloatWrapper.@NotNull FloatOnlyFunction function) {
		return new UFloatWrapperImpl(
			function.apply(getAsShort())
		);
	}
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UFloatWrapper containing the result of the function
	 */
	@Override
	public @NotNull UDoubleWrapper apply(UDoubleWrapper.@NotNull DoubleOnlyFunction function) {
		return new UDoubleWrapperImpl(
			function.apply(getAsShort())
		);
	}
	
	/**
	 * Gets a short value.
	 *
	 * @return a short value
	 */
	@Override
	public short getAsShort() {
		synchronized (lock) {
			return (short) Math.max(min, Math.min(value, max));
		}
	}
	
	/**
	 * Sets the maximum value for the wrapped short value.
	 *
	 * @param value the maximum value
	 * @return this object
	 */
	@Override
	public @NotNull UShortWrapper max(@Range(from = 0, to = Short.MAX_VALUE) int value) {
		synchronized (lock) {
			max = (short) value;
			return this;
		}
	}
	
	/**
	 * Sets the minimum value for the wrapped short value.
	 *
	 * @param value the minimum value
	 * @return this object
	 */
	@Override
	public @NotNull UShortWrapper min(@Range(from = 0, to = Short.MIN_VALUE) int value) {
		synchronized (lock) {
			min = (short) value;
			return this;
		}
	}
	
	/**
	 * Converts a primitive wrapper to one of type object
	 *
	 * @return a new wrapper object with the contents of the main wrapper
	 */
	@Override
	public @NotNull UObjectWrapper<Short> toObjectWrapper() {
		return apply((int number) -> (Short) ((short) number));
	}
	
}
