package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0014Test {
    @Test
    public void testVersion1() {
        assertEquals("fl", new Number0014.Version1().invoke(new String[] { "flower","flow","flight" }));
        assertEquals("", new Number0014.Version1().invoke(new String[] { "dog","racecar","car" }));
        assertEquals("a", new Number0014.Version1().invoke(new String[] { "ab","a" }));
    }
}
