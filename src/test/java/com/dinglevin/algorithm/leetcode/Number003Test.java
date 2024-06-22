package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number003Test {
    @Test
    public void testLengthOfLongestSubstringV0() {
        assertEquals(2, Number003.lengthOfLongestSubstringV0("abba"));
        assertEquals(3, Number003.lengthOfLongestSubstringV0("abcabcbb"));
        assertEquals(1, Number003.lengthOfLongestSubstringV0("bbbbb"));
        assertEquals(3, Number003.lengthOfLongestSubstringV0("pwwkew"));
        assertEquals(4, Number003.lengthOfLongestSubstringV0("abcd"));
    }

    @Test
    public void testLengthOfLongestSubstringV1() {
        assertEquals(2, Number003.lengthOfLongestSubstringV1("abba"));
        assertEquals(3, Number003.lengthOfLongestSubstringV1("abcabcbb"));
        assertEquals(1, Number003.lengthOfLongestSubstringV1("bbbbb"));
        assertEquals(3, Number003.lengthOfLongestSubstringV1("pwwkew"));
        assertEquals(4, Number003.lengthOfLongestSubstringV1("abcd"));
    }
}
