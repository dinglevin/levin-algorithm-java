package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Number0010Test {
    @Test
    public void testVersion1() {
        // assertFalse(new Number0010.Version1().invoke("aa", "a"));
        assertTrue(new Number0010.Version1().invoke("aaaa", "a*"));
        assertTrue(new Number0010.Version1().invoke("ab", ".*"));
        assertFalse(new Number0010.Version1().invoke("ab", "*"));
    }
}
