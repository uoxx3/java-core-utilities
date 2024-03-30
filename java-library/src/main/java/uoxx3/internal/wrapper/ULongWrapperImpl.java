package uoxx3.internal.wrapper;

import org.jetbrains.annotations.NotNull;
import uoxx3.wrapper.*;

import java.util.function.LongConsumer;
import java.util.function.LongFunction;

public final class ULongWrapperImpl implements ULongWrapper {
	
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
	private final long value;
	
	/**
	 * The minimum primitive value
	 */
	private long min;
	
	/**
	 * The maximum primitive value
	 */
	private long max;
	
	/* -----------------------------------------------------
	 * Constructors
	 * ----------------------------------------------------- */
	
	/**
	 * Constructs a new wrapper with the specified content.
	 *
	 * @param content the content to wrap
	 */
	public ULongWrapperImpl(long content) {
		value = content;
		min = Long.MIN_VALUE;
		max = Long.MAX_VALUE;
	}
	
	/**
	 * Constructs a new wrapper with no content.
	 */
	public ULongWrapperImpl() {
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
	public @NotNull ULongWrapper also(@NotNull LongConsumer consumer) {
		consumer.accept(getAsLong());
		return this;
	}
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UObjectWrapper containing the result of the function
	 */
	@Override
	public @NotNull <R> UObjectWrapper<R> apply(@NotNull LongFunction<R> function) {
		return new UObjectWrapperImpl<>(
			function.apply(getAsLong())
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
			function.apply((byte) getAsLong())
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
			function.apply((short) getAsLong())
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
			function.apply((int) getAsLong())
		);
	}
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new ULongWrapper containing the result of the function
	 */
	@Override
	public @NotNull ULongWrapper apply(@NotNull LongOnlyFunction function) {
		return new ULongWrapperImpl(
			function.apply(getAsLong())
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
			function.apply(getAsLong())
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
			function.apply(getAsLong())
		);
	}
	
	/**
	 * Gets a result.
	 *
	 * @return a result
	 */
	@Override
	public long getAsLong() {
		synchronized (lock) {
			return Math.max(min, Math.min(value, max));
		}
	}
	
	/**
	 * Sets the maximum value for the wrapped long value.
	 *
	 * @param value the maximum value
	 * @return this object
	 */
	@Override
	public @NotNull ULongWrapper max(long value) {
		synchronized (lock) {
			max = value;
			return this;
		}
	}
	
	/**
	 * Sets the minimum value for the wrapped long value.
	 *
	 * @param value the minimum value
	 * @return this object
	 */
	@Override
	public @NotNull ULongWrapper min(long value) {
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
	public @NotNull UObjectWrapper<Long> toObjectWrapper() {
		return apply((long number) -> (Long) number);
	}
	
}
