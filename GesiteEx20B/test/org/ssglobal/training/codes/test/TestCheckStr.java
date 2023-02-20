package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.CheckStr;

public class TestCheckStr {
	@Test
	public void testConvertWithSpace() {
		CheckStr cs = new CheckStr();
		String str = "hello world";
		assertEquals("00111010001", cs.convert(str));
		System.out.println(cs.convert(str));
	}
	
	@Test
	public void testConvertEmpty() {
		CheckStr cs = new CheckStr();
		String str = "";
		assertEquals("", cs.convert(str));
		System.out.println(cs.convert(str));
	}
	
	@Test
	public void testConvertNull() {
		CheckStr cs = new CheckStr();
		String str = null;
		assertThrows(NullPointerException.class, () ->{
			assertNull(cs.convert(str));
			System.out.println(cs.convert(str));
		});
	}
	
	@Test
	public void testConvertWhiteSpaces() {
		CheckStr cs = new CheckStr();
		String str = "String\n\t";
		assertEquals("0101000101", cs.convert(str));
		System.out.println(cs.convert(str));
	}
	
	@Test
	public void testConvertMixedRainy() {
		CheckStr cs = new CheckStr();
		String str = "1234xml";
		assertNotEquals("0101000100", cs.convert(str));
		System.out.println(cs.convert(str));
	}
	
	
	@Test
	public void testTotal() {
		CheckStr cs = new CheckStr();
		String str = "I am a trainee";
		cs.total(str);
		System.out.println(cs.total(str));
	}
	
	@Test
	public void testBinarise() {
		CheckStr cs = new CheckStr();
		cs.binarise(4);
		System.out.println(cs.binarise(4));
	}
}
