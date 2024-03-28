package uoxx3.internal.wrapper;

import androidx.annotation.NonNull;
import uoxx3.wrapper.*;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;

public final class UDoubleWrapperImpl implements UDoubleWrapper {
	
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
	private final double value;
	
	/**
	 * The minimum primitive value
	 */
	private double min;
	
	/**
	 * The maximum primitive value
	 */
	private final double max;
	
	/* -----------------------------------------------------
	 * Constructors
	 * ----------------------------------------------------- */
	
	/**
	 * Constructs a new wrapper with the specified content.
	 *
	 * @param content the content to wrap
	 */
	public UDoubleWrapperImpl(double content) {
		value = content;
		min = Double.MIN_VALUE;
		max = Double.MAX_VALUE;
	}
	
	/**
	 * Constructs a new wrapper with no content.
	 */
	public UDoubleWrapperImpl() {
		this(0.0);
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
	public @NonNull UDoubleWrapper min(double value) {
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
	public @NonNull UDoubleWrapper max(double value) {
		synchronized (lock) {
			min = value;
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
	public @NonNull <R> UObjectWrapper<R> apply(@NonNull DoubleFunction<R> function) {
		return new UObjectWrapperImpl<>(
			function.apply(getAsDouble())
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
			function.apply((byte) getAsDouble())
		);
	}
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UShortWrapper containing the result of the function
	 */
	@Override
	public @NonNull UShortWrapper apply(@NonNull UShortWrapper.ShortOnlyFunction function) {
		return new UShortWrapperImpl(
			function.apply((short) getAsDouble())
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
			function.apply((int) getAsDouble())
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
			function.apply((long) getAsDouble())
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
			function.apply((float) getAsDouble())
		);
	}
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UFloatWrapper containing the result of the function
	 */
	@Override
	public @NonNull UDoubleWrapper apply(@NonNull DoubleOnlyFunction function) {
		return new UDoubleWrapperImpl(
			function.apply(getAsDouble())
		);
	}
	
	/**
	 * Performs the given action on the wrapped integer value and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@Override
	public @NonNull UDoubleWrapper also(@NonNull DoubleConsumer consumer) {
		consumer.accept(getAsDouble());
		return this;
	}
	
	/**
	 * Gets a result.
	 *
	 * @return a result
	 */
	@Override
	public double getAsDouble() {
		synchronized (lock) {
			return Math.max(min, Math.min(value, max));
		}
	}
	
}
