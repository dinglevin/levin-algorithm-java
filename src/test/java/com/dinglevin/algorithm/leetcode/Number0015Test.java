package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Number0015Test {
    @Test
    public void testVersion1() {
        assertEquals(Arrays.asList(Arrays.asList(-1,-1,2), Arrays.asList(-1,0,1)), 
            new Number0015.Version1().invoke(new int[] { -1,0,1,2,-1,-4 }));
        assertEquals(new ArrayList<>(), 
            new Number0015.Version1().invoke(new int[] { 0,1,1 }));
        assertEquals(Arrays.asList(Arrays.asList(0, 0, 0)), 
            new Number0015.Version1().invoke(new int[] { 0, 0, 0, 0 }));
    }
}
