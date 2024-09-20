package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0016Test {
    @Test
    public void testVersion1() {
        assertEquals(-2, new Number0016.Version1().invoke(new int[] { 4,0,5,-5,3,3,0,-4,-5 }, -2));
        assertEquals(3, new Number0016.Version1().invoke(new int[] { 1,1,1,0 }, 100));
        assertEquals(2, new Number0016.Version1().invoke(new int[] { -1,2,1,-4}, 1));
        assertEquals(0, new Number0016.Version1().invoke(new int[] { 0, 0, 0 }, 0));
    }
}
