package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0006Test {
    @Test
    public void testVersion1() {
        assertEquals("PAHNAPLSIIGYIR", new Number0006.Version1().invoke("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", new Number0006.Version1().invoke("PAYPALISHIRING", 4));
        assertEquals("A", new Number0006.Version1().invoke("A", 1));
        assertEquals("AB", new Number0006.Version1().invoke("AB", 1));
    }

    @Test
    public void testVersion2() {
        assertEquals("PAHNAPLSIIGYIR", new Number0006.Version2().invoke("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", new Number0006.Version2().invoke("PAYPALISHIRING", 4));
        assertEquals("A", new Number0006.Version2().invoke("A", 1));
        assertEquals("AB", new Number0006.Version1().invoke("AB", 1));
    }
}
