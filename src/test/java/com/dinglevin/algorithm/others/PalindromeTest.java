package com.dinglevin.algorithm.others;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 描述：PalindromeTest
 *
 * @author dinglevin
 * @since 2021/7/16 11:12 周五
 */
public class PalindromeTest {
    private Palindrome executor = new Palindrome();

    @Test
    public void testIsTrue() {
        assertTrue(executor.isTrue("a"));
        assertFalse(executor.isTrue("ab"));
        assertTrue(executor.isTrue("aba"));
        assertTrue(executor.isTrue("aa"));
        assertTrue(executor.isTrue("abba"));
        assertFalse(executor.isTrue("abbaa"));
    }
}
