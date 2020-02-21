package converter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class tests the current implementation of Converter. 
 *
 * Developer: Abhi Dubal
 * Purpose: AEM Assessment
 * Date: Feb 20, 2020
 */
class ConverterTest {

	@Test
	void normalConversionTest() {
		Converter converter = new Converter();
		String conversion = converter.integerToRomanNumeral("10");
		assertEquals("X", conversion);
	}
	
	@Test
	void extendedNormalConversionTest() {
		Converter converter = new Converter();
		String conversion = converter.integerToRomanNumeral("1037");
		assertEquals("MXXXVII", conversion);
	}
	
	@Test
	void testErrorCase()
	{
		Converter converter = new Converter();
		String conversion = converter.integerToRomanNumeral("40.5");
		assertEquals("ERROR", conversion);
	}
	
	@Test
	void testOutOfRangeCase()
	{
		Converter converter = new Converter();
		String conversion = converter.integerToRomanNumeral("4000");
		assertEquals("OUT OF RANGE", conversion);
	}

}
