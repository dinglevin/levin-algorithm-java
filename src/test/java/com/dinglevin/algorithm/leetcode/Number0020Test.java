package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0020Test {
    @Test
    public void testVersion1() {
        assertEquals(false, new Number0020.Version1().invoke("]"));
        assertEquals(false, new Number0020.Version1().invoke("["));
        assertEquals(true, new Number0020.Version1().invoke("()"));
        assertEquals(true, new Number0020.Version1().invoke("()[]{}"));
        assertEquals(false, new Number0020.Version1().invoke("(]"));
    }

    @Test
    public void testVersion2() {
        assertEquals(false, new Number0020.Version2().invoke("]"));
        assertEquals(false, new Number0020.Version2().invoke("["));
        assertEquals(true, new Number0020.Version2().invoke("()"));
        assertEquals(true, new Number0020.Version2().invoke("()[]{}"));
        assertEquals(false, new Number0020.Version2().invoke("(]"));
    }
}
