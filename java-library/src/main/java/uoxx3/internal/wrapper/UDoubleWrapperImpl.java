package uoxx3.internal.wrapper;

import org.jetbrains.annotations.NotNull;
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
	 * The maximum primitive value
	 */
	private final double max;
	/**
	 * The minimum primitive value
	 */
	private double min;
	
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
	
	/**
	 * Performs the given action on the wrapped integer value and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@Override
	public @NotNull UDoubleWrapper also(@NotNull DoubleConsumer consumer) {
		consumer.accept(getAsDouble());
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
			function.apply(getAsDouble())
		);
	}
	
	/* -----------------------------------------------------
	 * Methods
	 * ----------------------------------------------------- */
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UByteWrapper containing the result of the function
	 */
	@Override
	public @NotNull UByteWrapper apply(UByteWrapper.@NotNull ByteOnlyFunction function) {
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
	public @NotNull UShortWrapper apply(UShortWrapper.@NotNull ShortOnlyFunction function) {
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
	public @NotNull UIntegerWrapper apply(UIntegerWrapper.@NotNull IntOnlyFunction function) {
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
	public @NotNull ULongWrapper apply(ULongWrapper.@NotNull LongOnlyFunction function) {
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
	public @NotNull UFloatWrapper apply(UFloatWrapper.@NotNull FloatOnlyFunction function) {
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
	public @NotNull UDoubleWrapper apply(UDoubleWrapper.@NotNull DoubleOnlyFunction function) {
		return new UDoubleWrapperImpl(
			function.apply(getAsDouble())
		);
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
	
	/**
	 * Sets the maximum value for the wrapped primitive value.
	 *
	 * @param value the maximum value
	 * @return this object
	 */
	@Override
	public @NotNull UDoubleWrapper max(double value) {
		synchronized (lock) {
			min = value;
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
	public @NotNull UDoubleWrapper min(double value) {
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
	public @NotNull UObjectWrapper<Double> toObjectWrapper() {
		return apply((double number) -> (Double) number);
	}
	
}
