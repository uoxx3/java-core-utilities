package uoxx3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UClassTest {
	
	@Test
	public void multiDimensionalArrayComponentTypeTest() {
		// Invalid argument test
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Class<?> clsP = UClass.multiDimensionalArrayComponentType(1);
			System.err.println(clsP);
		});
		
		// Valid arguments test
		Class<?> cls1 = UClass.multiDimensionalArrayComponentType(new Class[0]);
		Class<?> cls2 = UClass.multiDimensionalArrayComponentType(new int[0][0][0]);
		
		Assertions.assertEquals(Class.class, cls1,
								"The data types do not match.");
		Assertions.assertEquals(int.class, cls2,
								"The data types do not match.");
		
		System.err.println(cls1);
		System.err.println(cls2);
	}
	
}