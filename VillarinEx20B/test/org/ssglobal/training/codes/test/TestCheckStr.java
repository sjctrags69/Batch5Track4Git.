package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.CheckStr;

public class TestCheckStr {
private CheckStr checkStr;
	
	@BeforeEach
	public void setup() {
		checkStr = new CheckStr();
	}
	
	@AfterEach
	public void tearDown() {
		checkStr = null;
	}
	
	@Test
	public void testTotal() {
		int result = checkStr.total("hello");
		assertNotEquals(0, result);
	}
	
	@Test
	public void testTotalRainy() {
		int result = checkStr.total("hello");
		assertEquals(0, result);
	}
	
	@Test
	public void testBinarise() {
		String result = checkStr.binarise(010101);
		System.out.println(result);
		assertEquals("1000001000001", result);
	}
	
	@Test
	public void testBinariseRainy() {
		String result = checkStr.binarise(010101);
		System.out.println(result);
		assertEquals("", result);
	}
	
	@Test
	public void testConvertEmpty() {
		String result = checkStr.convert("");
		assertEquals("", result);
	}
	
	@Test
	public void testConvertEmptyRainy() {
		String result = checkStr.convert("");
		assertNotEquals("", result);
	}
	
	@Test
	public void testConvertNull() {
		assertThrows(NullPointerException.class, () -> {
			String result = checkStr.convert(null);
			assertEquals(null, result);
		});
		
	}
	
	@Test
	public void testConvertNullRainy() {
		assertDoesNotThrow(() -> {
			String result = checkStr.convert(null);
			assertNotEquals(null, result);
		});
	}
	
	@Test
	public void testConvertWhiteSpaces() {
		String result = checkStr.convert("\n\t\n\r");
		assertEquals("010101", result);
	}
	
	@Test
	public void testConvertWhiteSpacesRainy() {
		String result = checkStr.convert("\n\t\n\r");
		assertNotEquals("", result);
	}
	
	@Test
	public void testConvertWithSpaces() {
		String result = checkStr.convert("hello world");
		assertEquals("00111010001", result);
	}
	
	@Test
	public void testConvertWithSpacesRainy() {
		String result = checkStr.convert("hello world");
		assertNotEquals("", result);
	}
	
	@Test
	public void testConvertWithNumbers() {
		String result = checkStr.convert("1234xml");
		assertEquals("1101100001", result);
	}
	
	@Test
	public void testConvertWithNumbersRainy() {
		String result = checkStr.convert("1234xml");
		assertEquals("1101100001", result);
	}
}
