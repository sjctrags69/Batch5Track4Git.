package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.ItemA.CheckStr;

public class TestCheckStr {
	private CheckStr cs;
	
	@BeforeEach
	public void startup() {
		cs = new CheckStr();
	}
	
	@AfterEach
	public void teardown() {
		cs = null;
	}
	
	@Test
	public void testConvertEmptyString() {
		assertEquals("", cs.convert(""));
	}
	
	@Test
	public void testConvertNull() {		
		String nullString = null;
		assertThrows(NullPointerException.class, ()-> {
			assertNull(cs.convert(nullString), "does not support null String");
		});
	}
	
	@Test
	public void testConvertWhitespaces() {
		assertNotNull(cs.convert("\\n\\t\\n\\r"), "does support white spaces");
	}
	
	@Test
	public void testConvertSpaces() {
		assertNotNull(cs.convert("hello world"), "does support spaces");
	}
	
	@Test
	public void testConvertStringNumbers() {
		assertNotNull(cs.convert("1234xml"), "does support String numbers");
	}
	
	@Test
	public void total() {
		assertEquals(750, cs.total("patrick"));
	}
	
	@Test
	public void totalRainy() {
		assertNotEquals(751, cs.total("patrick"));
	}
	
	@Test
	public void binarise() {
		assertEquals("0111011101", cs.binarise(cs.total("patrick")));
	}
	
	@Test
	public void binariseRainy() {
		assertNotEquals("1111111111", cs.binarise(cs.total("patrick")));
	}
}
