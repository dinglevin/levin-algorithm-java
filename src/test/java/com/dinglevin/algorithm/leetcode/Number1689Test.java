package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 描述：Number1689Test
 *
 * @author dinglevin
 * @since 2021/6/13 11:06 周日
 */
public class Number1689Test {
    @Test
    public void testVersion1() {
        Number1689 executor = new Number1689();

        int result = executor.version1("32");
        assertEquals(3, result);
        System.out.println();

        result = executor.version1("82734");
        assertEquals(8, result);
        System.out.println();

        result = executor.version1("27346209830709182346");
        assertEquals(9, result);
        System.out.println();
    }

    @Test
    public void testVersion2() {
        Number1689 executor = new Number1689();

        int result = executor.version2("32");
        assertEquals(3, result);

        result = executor.version2("82734");
        assertEquals(8, result);

        result = executor.version2("27346209830709182346");
        assertEquals(9, result);
    }
}
