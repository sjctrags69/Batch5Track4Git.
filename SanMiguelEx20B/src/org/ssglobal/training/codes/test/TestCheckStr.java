package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.CheckStr;

public class TestCheckStr {
	private CheckStr cs;
	
	@BeforeEach
	public void setup() {
		cs = new CheckStr();
	}
	
	@AfterEach
	public void teardown() {
		cs = null;
	}
	
	@Test
	public void testConvertSunny() {
		String word = "Hello";
		assertNotNull(word);
	}
	
	@Test
	public void testConvertRainy() {
		String word = "Hello";
		assertNull(word);
	}
	
	@Test
	public void testTotalZeroSunny() {
		String word = "";
		int result = cs.total(word);
		assertEquals(0, result);
	}
	
	@Test
	public void testTotalZeroRainy() {
		String word = "Hello";
		int result = cs.total(word);
		assertEquals(0, result);
	}
	
	@Test
	public void testBinariseZeroSunny() {
		String word = "";
		int result = cs.total(word);
		assertEquals(0, result);
	}
	
	@Test
	public void testBinariseRainy() {
		String word = "dog";
		int result = cs.total(word);
		assertEquals(0, result);
	}
	
	@Test
	public void testConvertEmptyString() {
		String empty = "";
		String result = cs.convert(empty);
		String expectedString = "";
		assertEquals(expectedString, result);
	}
	
	@Test
	public void testConvertNullString() {
		String nullStr = null;
		assertDoesNotThrow(() -> {
			String result = cs.convert(nullStr);
			String expectedString = null;
			assertEquals(expectedString, result);
		});
	}
	
	@Test
	public void testConvertWhiteSpaceString() {
		String word = " Hello, World! ";
		String expectedResult = "Hello, world!";
		String result = cs.convert(word);
		
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testConvertSpaceString() {
		String word = "Hello, world";
        String expectedResult = "Hello, world";
        String result = cs.convert(word);
        
        assertEquals(expectedResult, result);
	}
	
	@Test
	public void testConvertNumbersString() {
		String wordWithNum = "abc123";
        String expectedResult = "abc123";
        String result = cs.convert(wordWithNum);
        
        assertEquals(expectedResult, result);
	}
}