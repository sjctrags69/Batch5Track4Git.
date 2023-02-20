package org.ssglobal.training.codes.test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.CheckStr;

public class testCheckStr {
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
	public void testTotal() {
		String str = "Count the string";
		int result = cs.total(str);
		assertTrue(result > str.length());
	}
	
	@Test
	public void testTotalRainy() {
		String str = "Count the string";
		int result = cs.total(str);
		assertFalse(result > str.length());
	}
	
	@Test
	public void testTotalEquals() {
		String str = "Count the string now";
		int result = cs.total(str);
		assertEquals(result, str.length());
	}
	
	@Test
	public void testTotalEqualsRainyl() {
		String str = "Count the string now";
		int result = cs.total(str);
		assertNotEquals(result, str.length());
	}
	
	@Test
	public void testBinarise() {
		String result = cs.binarise(75);
		String expectedResult = "b";
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testBinariseRainy() {
		String result = cs.binarise(75);
		String expectedResult = "b";
		assertNotEquals(expectedResult, result);
	}
	
	@Test
	public void testEmptyStr() {
		String result = cs.convert("");
		assertSame("", result);
	}
	
	@Test
	public void testEmptyStrRainy() {
		String result = cs.convert("");
		assertNotSame("", result);
	}
	
	@Test
	public void testNullStr() {
		String result = cs.convert(null);
		assertNull(result);
	}
	
	@Test
	public void testNullStrRainy() {
		String result = cs.convert(null);
		assertNotNull(result);
	}
	
	@Test
	public void testWhiteSpacesStr() {
		String result = cs.convert("\t\t\t");
		assertEquals("\t\t", result);
	}
	
	@Test
	public void testWhiteSpacesStrRainy() {
		String result = cs.convert("\t\t\t");
		assertEquals("\t\t\n", result);
	}
	
	@Test
	public void testSpacesStr() {
		String result = cs.convert("Hello World");
		assertEquals("Hello World", result);
	}
	
	@Test
	public void testSpacesStrRainy() {
		String result = cs.convert("Hello World");
		assertEquals("Hello World", result);
	}
	
	@Test
	public void testNumberStr() {
		String result = cs.convert("1234xml");
		assertEquals("1234cml", result);
	}
	
	@Test
	public void testNumberStrRainy() {
		String result = cs.convert("1234xml");
		assertNotEquals("1234cml", result);
	}
	
	
}
