package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.CheckStr;

public class TestCheckStr {
	
	private CheckStr mo;
	
	@BeforeEach
	public void setup() {
		mo = new CheckStr();
	}
	
	public void teardown() {
		mo = null;
	}
	
    @Test
    public void testConvertEmptyString() {
        assertEquals("", mo.convert(""));
    }
    
    @Test
    public void testConvertEmptyStringRainy() {
        assertNotEquals("1", mo.convert(""));
    }
    
    @Test
    public void testConvertNulString() {
        assertNull(mo.convert(null));
    }
    
    @Test
    public void testConvertNotNulString() {
        assertNotNull(mo.convert(null));
    }
    
    @Test
    public void testConvertWithWhiteSpaces() {
        assertEquals("0101001", mo.convert(" \n\t\n\r"));
    }
    
    @Test
    public void testConvertWithWhiteSpacesRainy() {
        assertNotEquals("0101001", mo.convert(" \n\t\n\r"));
    }
    
    @Test
    void testConvertStringWithSpaces() {
        assertEquals("10010001101111111011101100100", mo.convert("Hello world"));
    }

    @Test
    void testConvertStringNumbers() {
        assertEquals("1111010010", mo.convert("1234xml"));
    }

    
}
