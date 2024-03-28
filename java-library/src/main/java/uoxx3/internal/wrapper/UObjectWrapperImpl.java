package uoxx3.internal.wrapper;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uoxx3.wrapper.UObjectWrapper;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * An implementation of {@link UObjectWrapper}.
 *
 * @param <T> the type of the wrapped object
 */
public final class UObjectWrapperImpl<T> implements UObjectWrapper<T> {
	
	/* -----------------------------------------------------
	 * Properties
	 * ----------------------------------------------------- */
	
	/**
	 * The lock object for synchronization.
	 */
	private final Object lock = new Object();
	
	/**
	 * The wrapped object.
	 */
	private final T object;
	
	/* -----------------------------------------------------
	 * Constructors
	 * ----------------------------------------------------- */
	
	/**
	 * Constructs a new UObjectWrapperImpl with the specified content.
	 *
	 * @param content the content to wrap
	 */
	public UObjectWrapperImpl(@Nullable T content) {
		object = content;
	}
	
	/**
	 * Constructs a new UObjectWrapperImpl with no content.
	 */
	public UObjectWrapperImpl() {
		this(null);
	}
	
	/* -----------------------------------------------------
	 * Methods
	 * ----------------------------------------------------- */
	
	/**
	 * Applies the given function to the wrapped object and wraps the result.
	 *
	 * @param <R>      the type of the result
	 * @param function the function to apply
	 * @return a new UObjectWrapper containing the result of the function
	 */
	@Override
	public @NotNull <R> UObjectWrapper<R> apply(@NotNull Function<T, R> function) {
		return new UObjectWrapperImpl<>(
			function.apply(get())
		);
	}
	
	/**
	 * Applies the given function to the wrapped object and wraps the result if the wrapped object is not {@code <null>}.
	 *
	 * @param <R>      the type of the result
	 * @param function the function to apply
	 * @return an Optional containing a new UObjectWrapper with the result, or empty if the wrapped object is {@code <null>}
	 */
	@Override
	public @NotNull <R> UObjectWrapper<R> applyNotNull(@NotNull Function<Optional<T>, R> function) {
		return new UObjectWrapperImpl<>(
			function.apply(Optional.ofNullable(get()))
		);
	}
	
	/**
	 * Performs the given action on the wrapped object and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@Override
	public @NotNull UObjectWrapper<T> also(@NotNull Consumer<T> consumer) {
		// We only execute the action and return the same object
		consumer.accept(get());
		return this;
	}
	
	/**
	 * Performs the given action on the wrapped object if it is not null and returns the same object.
	 *
	 * @param consumer the action to perform
	 * @return this object
	 */
	@Override
	public @NotNull UObjectWrapper<T> alsoNotNull(@NotNull Consumer<T> consumer) {
		if (isNotNull()) consumer.accept(get());
		return this;
	}
	
	/**
	 * Gets the wrapped object.
	 *
	 * @return the wrapped object
	 */
	@Override
	public T get() {
		synchronized (lock) {
			return object;
		}
	}
	
}
