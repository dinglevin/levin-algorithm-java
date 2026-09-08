package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0028Test {
    @Test
    public void testVersion1() {
        assertEquals(0, new Number0028.Version1().invoke("a", "a"));
        assertEquals(0, new Number0028.Version1().invoke("sadbutsad", "sad"));
        assertEquals(-1, new Number0028.Version1().invoke("leetcode", "leeto"));
    }
}
