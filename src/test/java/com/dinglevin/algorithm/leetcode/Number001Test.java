package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Number001Test {
    @Test
    public void testTwoSumV1() {
        assertArrayEquals(new int[] { 0, 1 }, Number001.twoSumV1(new int[] { 2, 7, 11, 15 }, 9));
        assertArrayEquals(new int[] { 1, 2 }, Number001.twoSumV1(new int[] { 3, 2, 4 }, 6));
        assertArrayEquals(new int[] { 0, 1 }, Number001.twoSumV1(new int[] { 3, 3 }, 6));
    }

    @Test
    public void testTwoSumV2() {
        assertArrayEquals(new int[] { 0, 1 }, Number001.twoSumV2(new int[] { 2, 7, 11, 15 }, 9));
        assertArrayEquals(new int[] { 1, 2 }, Number001.twoSumV2(new int[] { 3, 2, 4 }, 6));
        assertArrayEquals(new int[] { 0, 1 }, Number001.twoSumV2(new int[] { 3, 3 }, 6));
    }

    @Test
    public void testTwoSumV3() {
        assertArrayEquals(new int[] { 0, 1 }, Number001.twoSumV3(new int[] { 2, 7, 11, 15 }, 9));
        assertArrayEquals(new int[] { 1, 2 }, Number001.twoSumV3(new int[] { 3, 2, 4 }, 6));
        assertArrayEquals(new int[] { 0, 1 }, Number001.twoSumV3(new int[] { 3, 3 }, 6));
    }
}
