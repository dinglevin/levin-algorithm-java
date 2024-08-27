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
    @Test
    public void testVersion1() {
        assertEquals("bb", new Number0005.Version1().invoke("abb"));
        assertEquals("bb", new Number0005.Version1().invoke("cbbd"));
        assertEquals("a", new Number0005.Version1().invoke("a"));
        assertEquals("a", new Number0005.Version1().invoke("abcdefg"));
    }

    @Test
    public void testVersion2() {
        assertEquals("bb", new Number0005.Version2().invoke("bb"));
        assertEquals("bb", new Number0005.Version2().invoke("abb"));
        assertEquals("bb", new Number0005.Version2().invoke("cbbd"));
    }

    @Test
    public void testVersion3() {
        assertEquals("bb", new Number0005.Version3().invoke("bb"));
        assertEquals("bb", new Number0005.Version3().invoke("abb"));
        assertEquals("bb", new Number0005.Version3().invoke("cbbd"));
    }
}
