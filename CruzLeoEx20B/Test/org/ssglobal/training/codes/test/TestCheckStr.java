package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.itemA.CheckStr;


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
	public void testConvert() {
		String result = cs.convert("hello");
		assertEquals("0010100001", result);
	}
	
	@Test
	public void testConvertRainy() {
		String result = cs.convert("world");
		assertNotEquals("0010100001", result);
	}
	
	@Test
	public void testTotal() {
		int result = cs.total("Hello");
		assertEquals(500, result);
	}
	
	@Test
	public void testTotalRainy() {
		int result = cs.total("world");
		assertNotEquals(500, result);
	}
	
	@Test
	public void testBinarise() {
		String result = cs.binarise(10);
		assertEquals("0101", result);
	}
	
	@Test
	public void testBinariseRainy() {
		String result = cs.binarise(256);
		assertNotEquals("000101", result);
	}
	
	@Test
	public void testConvertEmpty() {
		String result = cs.convert("");
		assertTrue(result == "");
	}
	
	@Test
	public void testConvertNull() {
		assertThrows(NullPointerException.class, () -> {
			String result = cs.convert(null);
			assertTrue(result == null);
		});
	}
	
	@Test
	public void testConvertWhiteSpaces() {
		String result = cs.convert("\n\t\n\r");
		assertEquals("010101", result);
	}
	
	@Test
	public void testConvertWithSpaces() {
		String result = cs.convert("hello world");
		assertEquals("00111010001", result);
	}
	
	@Test
	public void testConvertWithStringNum() {
		String result = cs.convert("1234xml");
		assertEquals("1101100001", result);
	}
}
