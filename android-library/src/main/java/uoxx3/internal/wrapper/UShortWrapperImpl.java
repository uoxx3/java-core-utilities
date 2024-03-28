package uoxx3.internal.wrapper;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
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
	public UShortWrapperImpl(@IntRange(from = Short.MIN_VALUE, to = Short.MAX_VALUE) int content) {
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
	 * Sets the minimum value for the wrapped short value.
	 *
	 * @param value the minimum value
	 * @return this object
	 */
	@Override
	public @NonNull UShortWrapper min(@IntRange(from = Short.MIN_VALUE, to = 0) int value) {
		synchronized (lock) {
			min = (short) value;
			return this;
		}
	}
	
	/**
	 * Sets the maximum value for the wrapped short value.
	 *
	 * @param value the maximum value
	 * @return this object
	 */
	@Override
	public @NonNull UShortWrapper max(@IntRange(from = 0, to = Short.MAX_VALUE) int value) {
		synchronized (lock) {
			max = (short) value;
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
	public @NonNull <R> UObjectWrapper<R> apply(@NonNull IntFunction<R> function) {
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
	public @NonNull UByteWrapper apply(@NonNull UByteWrapper.ByteOnlyFunction function) {
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
	public @NonNull UShortWrapper apply(@NonNull ShortOnlyFunction function) {
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
	public @NonNull UIntegerWrapper apply(@NonNull UIntegerWrapper.IntOnlyFunction function) {
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
	public @NonNull ULongWrapper apply(@NonNull ULongWrapper.LongOnlyFunction function) {
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
	public @NonNull UFloatWrapper apply(@NonNull UFloatWrapper.FloatOnlyFunction function) {
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
	public @NonNull UDoubleWrapper apply(@NonNull UDoubleWrapper.DoubleOnlyFunction function) {
		return new UDoubleWrapperImpl(
			function.apply(getAsShort())
		);
	}
	
	/**
	 * Performs the given action on the wrapped integer value and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@Override
	public @NonNull UShortWrapper also(@NonNull IntConsumer consumer) {
		consumer.accept(getAsShort());
		return this;
	}
	
}
