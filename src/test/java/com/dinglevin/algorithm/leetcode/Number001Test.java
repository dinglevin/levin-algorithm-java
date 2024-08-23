package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Number001Test {
    @Test
    public void testTwoSumV1() {
        assertArrayEquals(new int[] { 0, 1 }, new Number001.Version1().invoke(new int[] { 2, 7, 11, 15 }, 9));
        assertArrayEquals(new int[] { 1, 2 }, new Number001.Version1().invoke(new int[] { 3, 2, 4 }, 6));
        assertArrayEquals(new int[] { 0, 1 }, new Number001.Version1().invoke(new int[] { 3, 3 }, 6));
    }

    @Test
    public void testTwoSumV2() {
        assertArrayEquals(new int[] { 0, 1 }, new Number001.Version2().invoke(new int[] { 2, 7, 11, 15 }, 9));
        assertArrayEquals(new int[] { 1, 2 }, new Number001.Version2().invoke(new int[] { 3, 2, 4 }, 6));
        assertArrayEquals(new int[] { 0, 1 }, new Number001.Version2().invoke(new int[] { 3, 3 }, 6));
    }

    @Test
    public void testTwoSumV3() {
        assertArrayEquals(new int[] { 0, 1 }, new Number001.Version3().invoke(new int[] { 2, 7, 11, 15 }, 9));
        assertArrayEquals(new int[] { 1, 2 }, new Number001.Version3().invoke(new int[] { 3, 2, 4 }, 6));
        assertArrayEquals(new int[] { 0, 1 }, new Number001.Version3().invoke(new int[] { 3, 3 }, 6));
    }
}
