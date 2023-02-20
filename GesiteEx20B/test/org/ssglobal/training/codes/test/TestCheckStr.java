package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.CheckStr;

public class TestCheckStr {
	
	@Test
	public void convertEmpty() {
		CheckStr cs = new CheckStr();
		String str = "";
		assertEquals("", cs.convert(str));
	}
	
	@Test
	public void convertNull() {
		CheckStr cs = new CheckStr();
		String str = null;
		assertThrows(NullPointerException.class, ()-> {
			assertEquals(null, cs.convert(str));
		});
	}
	
	@Test
	public void convertWhiteSpaces() {
		CheckStr cs = new CheckStr();
		String str = "String\n\t";
		assertNotEquals(01102204, cs.convert(str));
	}
	
	@Test
	public void convertWithSpaces() {
		CheckStr cs = new CheckStr();
		String str = "hello world";
		assertEquals(37008, cs.convert(str));
	}
	
	@Test
	public void convertMixed() {
		CheckStr cs = new CheckStr();
		String str = "1234xml";
		assertEquals(1101100001, cs.convert(str));
	}
	
	@Test
	public void total() {
		CheckStr cs = new CheckStr();
		String str = "I am a trainee";
		assertEquals(1216, cs.total(str));
	}
	
	@Test
	public void binarise() {
		CheckStr cs = new CheckStr();
		String str = "I am a trainee";
		int i = Integer.parseInt(str);
		assertNull(cs.binarise(i));
	}
	
}
