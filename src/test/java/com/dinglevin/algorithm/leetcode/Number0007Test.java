package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0007Test {
    @Test
    public void testVersion1() {
        assertEquals(-321, new Number0007.Version1().invoke(-123));
        assertEquals(21, new Number0007.Version1().invoke(120));
        assertEquals(0, new Number0007.Version1().invoke(0));
        assertEquals(321, new Number0007.Version1().invoke(123));
    }

    @Test
    public void testVersion2() {
        assertEquals(-321, new Number0007.Version2().invoke(-123));
        assertEquals(21, new Number0007.Version2().invoke(120));
        assertEquals(0, new Number0007.Version2().invoke(0));
        assertEquals(321, new Number0007.Version2().invoke(123));
    }

    @Test
    public void testVersion3() {
        assertEquals(-321, new Number0007.Version3().invoke(-123));
        assertEquals(21, new Number0007.Version3().invoke(120));
        assertEquals(0, new Number0007.Version3().invoke(0));
        assertEquals(321, new Number0007.Version3().invoke(123));
    }
}
