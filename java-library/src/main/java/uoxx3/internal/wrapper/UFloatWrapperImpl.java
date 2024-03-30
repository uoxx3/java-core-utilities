package uoxx3.internal.wrapper;

import org.jetbrains.annotations.NotNull;
import uoxx3.wrapper.*;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;

public final class UFloatWrapperImpl implements UFloatWrapper {
	
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
	private final float value;
	
	/**
	 * The minimum primitive value
	 */
	private float min;
	
	/**
	 * The maximum primitive value
	 */
	private float max;
	
	/* -----------------------------------------------------
	 * Constructors
	 * ----------------------------------------------------- */
	
	/**
	 * Constructs a new wrapper with the specified content.
	 *
	 * @param content the content to wrap
	 */
	public UFloatWrapperImpl(float content) {
		value = content;
		min = Long.MIN_VALUE;
		max = Long.MAX_VALUE;
	}
	
	/**
	 * Constructs a new wrapper with no content.
	 */
	public UFloatWrapperImpl() {
		this(0f);
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
	public @NotNull UFloatWrapper also(@NotNull DoubleConsumer consumer) {
		consumer.accept(getAsFloat());
		return this;
	}
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UObjectWrapper containing the result of the function
	 */
	@Override
	public @NotNull <R> UObjectWrapper<R> apply(@NotNull DoubleFunction<R> function) {
		return new UObjectWrapperImpl<>(
			function.apply(getAsFloat())
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
			function.apply((byte) getAsFloat())
		);
	}
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UShortWrapper containing the result of the function
	 */
	@Override
	public @NotNull UShortWrapper apply(UShortWrapper.@NotNull ShortOnlyFunction function) {
		return new UShortWrapperImpl(
			function.apply((short) getAsFloat())
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
			function.apply((int) getAsFloat())
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
			function.apply((long) getAsFloat())
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
			function.apply(getAsFloat())
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
			function.apply(getAsFloat())
		);
	}
	
	/**
	 * Gets a result.
	 *
	 * @return a result
	 */
	@Override
	public float getAsFloat() {
		synchronized (lock) {
			return Math.max(min, Math.min(value, max));
		}
	}
	
	/**
	 * Sets the maximum value for the wrapped primitive value.
	 *
	 * @param value the maximum value
	 * @return this object
	 */
	@Override
	public @NotNull UFloatWrapper max(float value) {
		synchronized (lock) {
			max = value;
			return this;
		}
	}
	
	/**
	 * Sets the minimum value for the wrapped primitive value.
	 *
	 * @param value the minimum value
	 * @return this object
	 */
	@Override
	public @NotNull UFloatWrapper min(float value) {
		synchronized (lock) {
			min = value;
			return this;
		}
	}
	
	/**
	 * Converts a primitive wrapper to one of type object
	 *
	 * @return a new wrapper object with the contents of the main wrapper
	 */
	@Override
	public @NotNull UObjectWrapper<Float> toObjectWrapper() {
		return apply((double number) -> (Float) ((float) number));
	}
	
}
