package uoxx3.internal.wrapper;

import org.jetbrains.annotations.NotNull;
import uoxx3.wrapper.*;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;

public final class UIntegerWrapperImpl implements UIntegerWrapper {
	
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
	private final int value;
	
	/**
	 * The minimum primitive value
	 */
	private int min;
	
	/**
	 * The maximum primitive value
	 */
	private int max;
	
	/* -----------------------------------------------------
	 * Constructors
	 * ----------------------------------------------------- */
	
	/* -----------------------------------------------------
	 * Constructors
	 * ----------------------------------------------------- */
	
	/**
	 * Constructs a new wrapper with the specified content.
	 *
	 * @param content the content to wrap
	 */
	public UIntegerWrapperImpl(int content) {
		value = content;
		min = Short.MIN_VALUE;
		max = Short.MAX_VALUE;
	}
	
	/**
	 * Constructs a new wrapper with no content.
	 */
	public UIntegerWrapperImpl() {
		this(0);
	}
	
	/* -----------------------------------------------------
	 * Methods
	 * ----------------------------------------------------- */
	
	/**
	 * Sets the minimum value for the wrapped primitive value.
	 *
	 * @param value the minimum value
	 * @return this object
	 */
	@Override
	public @NotNull UIntegerWrapper min(int value) {
		synchronized (lock) {
			min = value;
			return this;
		}
	}
	
	/**
	 * Sets the maximum value for the wrapped primitive value.
	 *
	 * @param value the maximum value
	 * @return this object
	 */
	@Override
	public @NotNull UIntegerWrapper max(int value) {
		synchronized (lock) {
			max = value;
			return this;
		}
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
			function.apply(getAsInt())
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
			function.apply((byte) getAsInt())
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
			function.apply((short) getAsInt())
		);
	}
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UIntegerWrapper containing the result of the function
	 */
	@Override
	public @NotNull UIntegerWrapper apply(@NotNull IntOnlyFunction function) {
		return new UIntegerWrapperImpl(
			function.apply(getAsInt())
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
			function.apply(getAsInt())
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
			function.apply(getAsInt())
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
			function.apply(getAsInt())
		);
	}
	
	/**
	 * Performs the given action on the wrapped integer value and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@Override
	public @NotNull UIntegerWrapper also(@NotNull IntConsumer consumer) {
		consumer.accept(getAsInt());
		return this;
	}
	
	/**
	 * Gets a result.
	 *
	 * @return a result
	 */
	@Override
	public int getAsInt() {
		synchronized (lock) {
			return Math.max(min, Math.min(value, max));
		}
	}
	
}
