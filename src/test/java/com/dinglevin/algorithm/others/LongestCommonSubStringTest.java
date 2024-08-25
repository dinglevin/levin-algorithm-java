package com.dinglevin.algorithm.others;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 描述：LongestCommonSubStringTest
 *
 * @author dinglevin
 * @since 2021/6/4 17:50 周五
 */
public class LongestCommonSubStringTest {
    private LongestCommonSubString executor = new LongestCommonSubString();

    @Test
    public void testVersion1() {
        LongestCommonSubString.Result result = executor.executeV1("abcd", "12345");
        assertEquals(0, result.getMaxLen());

        result = executor.executeV1("abcd1", "12345");
        assertEquals(1, result.getMaxLen());
        assertEquals("1", result.getSubString());

        result = executor.executeV1("1AB2345CD", "12345EF");
        assertEquals(4, result.getMaxLen());
        assertEquals("2345", result.getSubString());
    }

    @Test
    public void testVersion2() {
        LongestCommonSubString.Result result = executor.executeV2("abcd", "12345");
        assertEquals(0, result.getMaxLen());

        result = executor.executeV2("abcd1", "12345");
        assertEquals(1, result.getMaxLen());
        assertEquals("1", result.getSubString());

        result = executor.executeV2("1AB2345CD", "12345EF");
        assertEquals(4, result.getMaxLen());
        assertEquals("2345", result.getSubString());
    }

    @Test
    public void testVersion3() {
        LongestCommonSubString.Result result = executor.executeV3("abcd", "12345");
        assertEquals(0, result.getMaxLen());

        result = executor.executeV3("abcd1", "12345");
        assertEquals(1, result.getMaxLen());
        assertEquals("1", result.getSubString());

        result = executor.executeV3("1AB2345CD", "12345EF");
        assertEquals(4, result.getMaxLen());
        assertEquals("2345", result.getSubString());
    }
}
