package uoxx3.internal.wrapper;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import uoxx3.wrapper.*;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;

public final class UByteWrapperImpl implements UByteWrapper {
	
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
	private final byte value;
	
	/**
	 * The minimum primitive value
	 */
	private byte min;
	
	/**
	 * The maximum primitive value
	 */
	private byte max;
	
	/* -----------------------------------------------------
	 * Constructors
	 * ----------------------------------------------------- */
	
	/**
	 * Constructs a new UObjectWrapperImpl with the specified content.
	 *
	 * @param content the content to wrap
	 */
	public UByteWrapperImpl(@IntRange(from = Byte.MIN_VALUE, to = Byte.MAX_VALUE) int content) {
		value = (byte) content;
		min = Byte.MIN_VALUE;
		max = Byte.MAX_VALUE;
	}
	
	/**
	 * Constructs a new UObjectWrapperImpl with no content.
	 */
	public UByteWrapperImpl() {
		this(0);
	}
	
	/* -----------------------------------------------------
	 * Methods
	 * ----------------------------------------------------- */
	
	/**
	 * Performs the given action on the wrapped byte value and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@Override
	public @NonNull UByteWrapper also(@NonNull IntConsumer consumer) {
		consumer.accept(getAsByte());
		return this;
	}
	
	/**
	 * Applies the given function to the wrapped byte value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UObjectWrapper containing the result of the function
	 */
	@Override
	public @NonNull <R> UObjectWrapper<R> apply(@NonNull IntFunction<R> function) {
		return new UObjectWrapperImpl<>(
			function.apply(getAsByte())
		);
	}
	
	/**
	 * Applies the given function to the wrapped integer value and wraps the result.
	 *
	 * @param function the function to apply
	 * @return a new UByteWrapper containing the result of the function
	 */
	@Override
	public @NonNull UByteWrapper apply(@NonNull ByteOnlyFunction function) {
		return new UByteWrapperImpl(
			function.apply(getAsByte())
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
			function.apply(getAsByte())
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
			function.apply(getAsByte())
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
			function.apply(getAsByte())
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
			function.apply(getAsByte())
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
			function.apply(getAsByte())
		);
	}
	
	/**
	 * Creates a deep copy of the object.
	 *
	 * @return A deep copy of the object.
	 */
	@NonNull
	@Override
	public UByteWrapper copy() {
		return apply((byte v) -> v);
	}
	
	/**
	 * Gets a byte value.
	 *
	 * @return a byte value
	 */
	@Override
	public byte getAsByte() {
		synchronized (lock) {
			return (byte) Math.max(min, Math.min(value, max));
		}
	}
	
	/**
	 * Sets the maximum value for the wrapped byte value.
	 *
	 * @param value the maximum value
	 * @return this object
	 */
	@Override
	public @NonNull UByteWrapper max(@IntRange(from = 0, to = Byte.MAX_VALUE) int value) {
		synchronized (lock) {
			max = (byte) value;
			return this;
		}
	}
	
	/**
	 * Sets the minimum value for the wrapped byte value.
	 *
	 * @param value the minimum value
	 * @return this object
	 */
	@Override
	public @NonNull UByteWrapper min(@IntRange(from = Byte.MIN_VALUE, to = 0) int value) {
		synchronized (lock) {
			min = (byte) value;
			return this;
		}
	}
	
	/**
	 * Converts a primitive wrapper to one of type object
	 *
	 * @return a new wrapper object with the contents of the main wrapper
	 */
	@Override
	public @NonNull UObjectWrapper<Byte> toObjectWrapper() {
		return apply((int number) -> (Byte) ((byte) number));
	}
	
}
