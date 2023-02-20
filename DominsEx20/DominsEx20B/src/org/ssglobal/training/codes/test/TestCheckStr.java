package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.CheckStr;

public class TestCheckStr {
	private CheckStr check;
	
	@BeforeEach
	public void setup() {
		check = new CheckStr();
	}
	
	@AfterEach
	public void teardown() {
		check = null;
	}
	
	@Test
	public void testConvertEmpty() {
		String result = check.convert("");
		assertEquals("", result);
	}
	
	@Test
	public void testConvertNull() {
		String result = check.convert(null);
		assertEquals(null, result);
	}
	
	@Test
	public void testConvertNullRainy() {
		
		assertThrows(NullPointerException.class, () ->{
			 check.convert(null);
		});
	}
	
	@Test
	public void testConvertWhiteSpace() {
		String result = check.convert("\n\t\n\r");
		assertEquals("010101", result);
	}
	
	@Test
	public void testConvertWithSpace() {
		String result = check.convert("hello world");
		assertEquals("00111010001", result);
	}
	
	@Test
	public void testConvertWithNumbers() {
		String result = check.convert("1234xml");
		assertEquals("1101100001", result);
	}
	
}
