package uoxx3;

import org.jetbrains.annotations.NotNull;

/**
 * A generic interface for objects that can create deep copies of themselves.
 *
 * @param <T> The type of object that this interface can create copies of.
 */
public interface UCopyable<T> {
	
	/**
	 * Creates a deep copy of the object.
	 *
	 * @return A deep copy of the object.
	 */
	@NotNull T copy();
	
}