package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
	public void testConvert() {
		String str = "hello";
		String convert = cs.binarise(cs.total(str));
		System.out.println(convert);
		assertEquals("0010100001", convert);
	}
	
	@Test
	public void testConvertRainy() {
		String str = "hello";
		String convert = cs.binarise(cs.total(str));
		System.out.println(convert);
		assertNotEquals("0010100000", convert);
	}
	
	@Test
	public void testTotal() {
		String str = "hello";
		int total = cs.total(str);
		System.out.println(total);
        assertEquals(532, total);
		
	}
	
	@Test
	public void testTotalRainy() {
		String str = "hello";
		int total = cs.total(str);
		System.out.println(total);
        assertNotEquals(456, total);
		
	}
	
	@Test
	public void testBinarise() {
		int givenstrvalue = 0;
		String binarise = cs.binarise(givenstrvalue);
		System.out.println(binarise);
		assertEquals("", binarise);
	}
	
	@Test
	public void testBinariseRainy() {
		int givenstrvalue = 0;
		String binarise = cs.binarise(givenstrvalue);
		System.out.println(binarise);
		assertNotEquals("hello", binarise);
	}
	

}
