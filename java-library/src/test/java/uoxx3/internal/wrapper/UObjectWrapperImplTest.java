package uoxx3.internal.wrapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uoxx3.UObjects;

import java.util.NoSuchElementException;

public class UObjectWrapperImplTest {
	
	@Test
	public void wrapped() {
		var wrapped = UObjects.wrapper(12)
			.apply(n -> n * 12f)
			.apply(n -> n / 12.0)
			.get();
		
		Assertions.assertEquals(Double.class, wrapped.getClass(),
								"The content is not the same type");
		Assertions.assertEquals((12 * 12f) / 12.0, wrapped,
								"The content is not equal");
		
		System.err.printf("Content wrapped are: %f%n", wrapped);
		
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			var unknownWrapped = UObjects.wrapper(null)
				.apply(v -> v == null ? 1 : v)
				.apply(v -> null)
				.getNotNull()
				.get();
			
			System.err.printf("Content wrapped are: %s%n", unknownWrapped);
		});
	}
	
	
}