package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 描述：Number5Test
 *
 * @author dinglevin
 * @since 2021/6/27 12:57 周日
 */
public class Number0005Test {
    private Number0005 executor = new Number0005();

    @Test
    public void testVersion1LongestPalindrome() {
        assertEquals("bb", executor.version1LongestPalindrome("abb"));
        assertEquals("bb", executor.version1LongestPalindrome("cbbd"));
    }

    @Test
    public void testVersion2LongestPalindrome() {
        assertEquals("bb", executor.version2LongestPalindrome("bb"));
        assertEquals("bb", executor.version2LongestPalindrome("abb"));
        assertEquals("bb", executor.version2LongestPalindrome("cbbd"));
    }
}
