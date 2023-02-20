package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
	public void testConvert() {
		String toConvert = "Batch5";
		String result = check.convert(toConvert);
		assertEquals("1110100001", result);
	}
	
	@Test
	public void testConvertRainy() {
		String toConvert = "";
		String result = check.convert(toConvert);
		assertNotEquals("", result);
	}
	
	@Test
	public void testTotal() {
		String toConvert = "Batch5";
		int result =  check.total(toConvert);
		assertEquals(535,result);
	}
	
	@Test
	public void testTotalRainy() {
		String toConvert = "";
		int result =  check.total(toConvert);
		assertNotEquals(0,result);
	}
	
	@Test
	public void testBinarise() {
		int toConvert = 535;
		String result =  check.binarise(toConvert);
		assertEquals("1110100001",result);
	}
	
	@Test
	public void testBinariseRainy() {
		int toConvert = 0;
		String result =  check.binarise(toConvert);
		assertNotEquals("",result);
	}
}

