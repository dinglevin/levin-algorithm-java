package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0029Test {
    @Test
    public void testVersion1() {
        assertEquals(2147483647, new Number0029.Version1().invoke(-2147483648, -1));
        assertEquals(1, new Number0029.Version1().invoke(1, 1));
        assertEquals(3, new Number0029.Version1().invoke(10, 3));
        assertEquals(-2, new Number0029.Version1().invoke(7, -3));
    }
}
