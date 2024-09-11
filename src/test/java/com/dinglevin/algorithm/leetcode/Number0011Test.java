package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0011Test {
    @Test
    public void testVersion1() {
        assertEquals(49, new Number0011.Version1().invoke(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        assertEquals(1, new Number0011.Version1().invoke(new int[] { 1, 1 }));
    }
}
