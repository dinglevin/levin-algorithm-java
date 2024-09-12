package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0012Test {
    @Test
    public void testVersion1() {
        assertEquals("MMMDCCXLIX", new Number0012.Version1().invoke(3749));
        assertEquals("LVIII", new Number0012.Version1().invoke(58));
        assertEquals("MCMXCIV", new Number0012.Version1().invoke(1994));
    }

    @Test
    public void testVersion2() {
        assertEquals("MMMDCCXLIX", new Number0012.Version2().invoke(3749));
        assertEquals("LVIII", new Number0012.Version2().invoke(58));
        assertEquals("MCMXCIV", new Number0012.Version2().invoke(1994));
    }
}
