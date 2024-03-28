package uoxx3;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import uoxx3.internal.wrapper.*;
import uoxx3.wrapper.*;

public final class UObjects {
	
	/**
	 * This class cannot be instantiated
	 */
	private UObjects() {
		throw new Error("cannot be instantiated");
	}
	
	/* -----------------------------------------------------
	 * Wrapper methods
	 * ----------------------------------------------------- */
	
	/**
	 * Creates a new instance of {@link UObjectWrapper} with the specified value.
	 *
	 * @param <T>   the type of the value
	 * @param value the value to wrap
	 * @return a new UObjectWrapper instance containing the specified value
	 */
	public static <T> @NonNull UObjectWrapper<T> wrapper(@Nullable T value) {
		return new UObjectWrapperImpl<>(value);
	}
	
	/**
	 * Creates a new instance of {@link UObjectWrapper} with no initial value.
	 *
	 * @param <T> the type of the value
	 * @return a new UObjectWrapper instance with no initial value
	 */
	public static <T> @NonNull UObjectWrapper<T> wrapper() {
		return new UObjectWrapperImpl<>();
	}
	
	/**
	 * Creates a new instance of {@link UCharWrapper} with the specified value.
	 *
	 * @param value the char value to wrap
	 * @return a new UCharWrapper instance containing the specified value
	 */
	public static @NonNull UCharWrapper charWrapper(char value) {
		return new UCharWrapperImpl(value);
	}
	
	/**
	 * Creates a new instance of {@link UByteWrapper} with the specified value.
	 *
	 * @param value the byte value to wrap
	 * @return a new UByteWrapper instance containing the specified value
	 */
	public static @NonNull UByteWrapper byteWrapper(@IntRange(from = Byte.MIN_VALUE, to = Byte.MAX_VALUE) int value) {
		return new UByteWrapperImpl(value);
	}
	
	/**
	 * Creates a new instance of {@link UShortWrapper} with the specified value.
	 *
	 * @param value the short value to wrap
	 * @return a new UShortWrapper instance containing the specified value
	 */
	public static @NonNull UShortWrapper shortWrapper(@IntRange(from = Short.MIN_VALUE, to = Short.MAX_VALUE) int value) {
		return new UShortWrapperImpl(value);
	}
	
	/**
	 * Creates a new instance of {@link UIntegerWrapper} with the specified value.
	 *
	 * @param value the int value to wrap
	 * @return a new UIntegerWrapper instance containing the specified value
	 */
	public static @NonNull UIntegerWrapper intWrapper(int value) {
		return new UIntegerWrapperImpl(value);
	}
	
	/**
	 * Creates a new instance of {@link ULongWrapper} with the specified value.
	 *
	 * @param value the long value to wrap
	 * @return a new ULongWrapper instance containing the specified value
	 */
	public static @NonNull ULongWrapper longWrapper(long value) {
		return new ULongWrapperImpl(value);
	}
	
	/**
	 * Creates a new instance of {@link UFloatWrapper} with the specified value.
	 *
	 * @param value the float value to wrap
	 * @return a new UFloatWrapper instance containing the specified value
	 */
	public static @NonNull UFloatWrapper floatWrapper(float value) {
		return new UFloatWrapperImpl(value);
	}
	
	/**
	 * Creates a new instance of {@link UDoubleWrapper} with the specified value.
	 *
	 * @param value the double value to wrap
	 * @return a new UDoubleWrapper instance containing the specified value
	 */
	public static @NonNull UDoubleWrapper doubleWrapper(double value) {
		return new UDoubleWrapperImpl(value);
	}
	
}
