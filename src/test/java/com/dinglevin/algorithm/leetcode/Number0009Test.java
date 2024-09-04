package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0009Test {
    @Test
    public void testVersion1() {
        assertEquals(true, new Number0009.Version1().invoke(121));
        assertEquals(false, new Number0009.Version1().invoke(-121));
        assertEquals(false, new Number0009.Version1().invoke(10));
    }

    @Test
    public void testVersion2() {
        assertEquals(true, new Number0009.Version2().invoke(121));
        assertEquals(false, new Number0009.Version2().invoke(-121));
        assertEquals(false, new Number0009.Version2().invoke(10));
    }
}
