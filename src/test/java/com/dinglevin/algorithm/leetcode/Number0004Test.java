package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0004Test {
    @Test
    public void testFindMedianSortedArraysV1() {
        assertEquals(2.0, new Number0004.Version1().invoke(new int[] { 1, 3 }, new int[] { 2 }), 0.0);
        assertEquals(2.5, new Number0004.Version1().invoke(new int[] { 1, 2 }, new int[] { 3, 4 }), 0.0);
    }

    @Test
    public void testFindMedianSortedArraysV2() {
        assertEquals(2.0, new Number0004.Version2().invoke(new int[] { 1, 3 }, new int[] { 2 }), 0.0);
        assertEquals(2.5, new Number0004.Version2().invoke(new int[] { 1, 2 }, new int[] { 3, 4 }), 0.0);
    }
}
