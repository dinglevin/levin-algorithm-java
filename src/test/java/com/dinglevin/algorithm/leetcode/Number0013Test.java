package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0013Test {
    @Test
    public void testVersion1() {
        assertEquals(3, new Number0013.Version1().invoke("III"));
        assertEquals(58, new Number0013.Version1().invoke("LVIII"));
        assertEquals(1994, new Number0013.Version1().invoke("MCMXCIV"));
    }

    @Test
    public void testVersion2() {
        assertEquals(3, new Number0013.Version2().invoke("III"));
        assertEquals(58, new Number0013.Version2().invoke("LVIII"));
        assertEquals(1994, new Number0013.Version2().invoke("MCMXCIV"));
    }
}
