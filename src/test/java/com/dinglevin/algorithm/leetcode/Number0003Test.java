package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0003Test {
    @Test
    public void testLengthOfLongestSubstringV1() {
        assertEquals(2, new Number0003.Version1().invoke("abba"));
        assertEquals(3, new Number0003.Version1().invoke("abcabcbb"));
        assertEquals(1, new Number0003.Version1().invoke("bbbbb"));
        assertEquals(3, new Number0003.Version1().invoke("pwwkew"));
        assertEquals(4, new Number0003.Version1().invoke("abcd"));
    }

    @Test
    public void testLengthOfLongestSubstringV2() {
        assertEquals(2, new Number0003.Version2().invoke("abba"));
        assertEquals(3, new Number0003.Version2().invoke("abcabcbb"));
        assertEquals(1, new Number0003.Version2().invoke("bbbbb"));
        assertEquals(3, new Number0003.Version2().invoke("pwwkew"));
        assertEquals(4, new Number0003.Version2().invoke("abcd"));
    }
}
