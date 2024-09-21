package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Number0018Test {
    @Test
    public void testVersion1() {
        assertEquals(Arrays.asList(Arrays.asList(0,0,0,1000000000)), 
            new Number0018.Version1().invoke(new int[] {0,0,0,1000000000,1000000000,1000000000,1000000000}, 1000000000));
        assertEquals(Arrays.asList(Arrays.asList(-2,-1,1,2), Arrays.asList(-2,0,0,2), Arrays.asList(-1,0,0,1)), 
            new Number0018.Version1().invoke(new int[] { 1,0,-1,0,-2,2 }, 0));
        assertEquals(Arrays.asList(Arrays.asList(2,2,2,2)), 
            new Number0018.Version1().invoke(new int[] { 2,2,2,2,2 }, 8));
    }
}
