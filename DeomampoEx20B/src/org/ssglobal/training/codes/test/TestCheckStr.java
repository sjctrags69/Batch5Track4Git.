package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	public void tearDown() {
		cs = null;
	}
	@Test
	public void testConvertSunny() {
		String expectedResult = "";
		String result = cs.convert("");
		
		assertEquals(expectedResult, result);
	}
	@Test
	public void testConvertRainy() {
		String expectedResult = "Nomyr";
		String result = cs.convert(null);
		
		assertEquals(expectedResult, result);
	}
	@Test
	public void testTotalSunny() {
		int result = cs.total("");
		int expectedResult = result;
		
		assertEquals(expectedResult, result);
	}
	@Test
	public void testTotalRainy() {
		int result = cs.total("Nomyr");
		int expectedResult = 3;
		
		assertEquals(expectedResult, result);
	}
	@Test
	public void testBinariseSunny() {
		String result = cs.binarise(22);
		String expectedResult = result;
		
		assertEquals(expectedResult, result);
	}
	@Test
	public void testBinariseRainy() {
		String result = cs.binarise(22);
		String expectedResult =	"Hello World";
		
		assertEquals(expectedResult, result);
	}
}
