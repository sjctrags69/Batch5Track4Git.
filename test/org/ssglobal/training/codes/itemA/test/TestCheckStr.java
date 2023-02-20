package org.ssglobal.training.codes.itemA.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.itemA.CheckStr;


public class TestCheckStr {
	private CheckStr checker;
	
	@BeforeEach
	public void setup() {
		checker = new CheckStr();
	}
	
	@AfterEach
	public void teardown() {
		checker = null;
	}
	
	@Test
	public void testConvert() {
		String value = checker.convert("123");
		String expectedValue = "01101001";
		assertEquals(expectedValue, value);
	}
	
	@Test
	public void testConvertRainy() {
		String value = checker.convert("00000");
		String expectedValue = "0";
		assertNotEquals(expectedValue, value);
	}
	
	@Test
	public void testTotal() {
		int length = checker.total("123");
		int expectedLength = 150;
		assertEquals(expectedLength, length);
	}
	
	@Test
	public void testTotalRainy() {
		int length = checker.total("123");
		int expectedLength = 3;
		assertNotEquals(expectedLength, length);
	}
	
	@Test
	public void testBinarise() {
		String value = checker.binarise(123);
		String expectedValue = "1101111";
		
		assertEquals(expectedValue, value);
	}
	
	@Test
	public void testBinariseRainy() {
		String value = checker.binarise(123);
		System.out.println(value);
		String expectedValue = "1111011";
		
		assertNotEquals(expectedValue, value);
	}
	
	@Test
	public void testConvertAcceptsEmptyString() {
		String value =  checker.convert("");
		String expectedValue = "";
		assertEquals(expectedValue, value);
	}
	
	@Test
	public void testConvertAcceptsNullString() {
		String value = checker.convert(null);
		String expectedValue = null;
		assertEquals(expectedValue, value);
	}
	
	@Test
	public void testConvertAcceptsWhiteSpaces() {
		String value = checker.convert("\n\t\n\r");
		String expectedValue = "\n\t\n\r";
		
		/* If this run without error it accepts the value and 
		convert it to a binary and not the expected value*/
		assertNotEquals(expectedValue, value);
	}
	
	@Test
	public void testConvertAcceptsStringWithSpaces() {
		String value = checker.convert("hello world");
		System.out.println(value);
		String expectedValue = "hello world";
		
		/* If this run without error it accepts the value and 
		convert it to a binary and not the expected value*/
		assertNotEquals(expectedValue, value);
	}
	
	@Test
	public void testConvertAcceptsStringNumbers() {
		String value = checker.convert("1234xml");
		String expectedValue = "1234xml";
		
		/* If this run without error it accepts the value and 
		convert it to a binary and not the expected value*/
		assertNotEquals(expectedValue, value);
	}
	

	
}
