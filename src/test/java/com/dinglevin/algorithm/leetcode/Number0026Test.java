package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0026Test {
    @Test
    public void testVersion1() {
        assertEquals(5, new Number0026.Version1().invoke(new int[] { 0,0,1,1,1,2,2,3,3,4 }));
        assertEquals(5, new Number0026.Version1().invoke(new int[] { 1, 2, 3, 4, 5 }));
        assertEquals(2, new Number0026.Version1().invoke(new int[] { 1,1,2 }));
    }
}
