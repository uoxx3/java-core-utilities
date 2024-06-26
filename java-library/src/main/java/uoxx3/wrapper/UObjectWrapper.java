package uoxx3.wrapper;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uoxx3.UCopyable;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * A generic wrapper interface for objects.
 *
 * @param <T> the type of the wrapped object
 */
public interface UObjectWrapper<T> extends Supplier<T>, UCopyable<UObjectWrapper<T>> {
	
	/**
	 * Performs the given action on the wrapped object and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@NotNull UObjectWrapper<T> also(@NotNull Consumer<T> consumer);
	
	/**
	 * Performs the given action on the wrapped object if it is not null and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@NotNull UObjectWrapper<T> alsoNotNull(@NotNull Consumer<T> consumer);
	
	/**
	 * Applies the given function to the wrapped object and wraps the result.
	 *
	 * @param <R>      the type of the result
	 * @param function the function to apply
	 * @return a new UObjectWrapper containing the result of the function
	 */
	<R> @NotNull UObjectWrapper<R> apply(@NotNull Function<T, R> function);
	
	/**
	 * Applies the given function to the wrapped object and wraps the result if the wrapped object is not {@code <null>}.
	 *
	 * @param <R>      the type of the result
	 * @param function the function to apply
	 * @return an Optional containing a new UObjectWrapper with the result, or empty if the wrapped object is {@code <null>}
	 */
	<R> @NotNull UObjectWrapper<R> applyNotNull(@NotNull Function<Optional<T>, R> function);
	
	/**
	 * Checks if the content is equal to the specified object.
	 *
	 * @param other The object to compare against.
	 * @return {@code true} if the array content is equal to the specified object, {@code false} otherwise.
	 */
	default boolean contentEquals(@Nullable T other) {
		return Objects.deepEquals(get(), other);
	}
	
	/**
	 * Checks if the content is equal to the specified object.
	 *
	 * @param other The object to compare against.
	 * @return {@code true} if the array content is equal to the specified object, {@code false} otherwise.
	 */
	@SuppressWarnings("DataFlowIssue")
	default boolean contentEquals(@Nullable UObjectWrapper<T> other) {
		return contentEquals(other.get());
	}
	
	/**
	 * Gets the wrapped object, throwing a NullPointerException if it is {@code <null>}.
	 *
	 * @return the wrapped object
	 * @throws NullPointerException if the wrapped object is {@code <null>}
	 */
	default @NotNull Optional<T> getNotNull() {
		return Optional.ofNullable(get());
	}
	
	/**
	 * Performs the given action on the wrapped object if it is not {@code <null>}.
	 *
	 * @param consumer the action to perform
	 */
	default void ifNotNull(@NotNull Consumer<T> consumer) {
		if (isNull()) return;
		consumer.accept(get());
	}
	
	/**
	 * Checks if the wrapped object is not {@code <null>}.
	 *
	 * @return {@code true} if the wrapped object is not {@code <null>}, otherwise {@code false}
	 */
	default boolean isNotNull() {
		return !isNull();
	}
	
	/**
	 * Checks if the wrapped object is {@code <null>}.
	 *
	 * @return true if the wrapped object is {@code <null>}, otherwise false
	 */
	default boolean isNull() {
		return get() == null;
	}
	
}
