package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0008Test {
    @Test
    public void testVersion1() {
        assertEquals(0, new Number0008.Version1().invoke(" "));
        assertEquals(0, new Number0008.Version1().invoke("-+12"));
        assertEquals(42, new Number0008.Version1().invoke("42"));
        assertEquals(-42, new Number0008.Version1().invoke(" -042"));
        assertEquals(1337, new Number0008.Version1().invoke("1337c0d3"));
        assertEquals(0, new Number0008.Version1().invoke("0-1"));
        assertEquals(0, new Number0008.Version1().invoke("words and 987"));
    }
}
