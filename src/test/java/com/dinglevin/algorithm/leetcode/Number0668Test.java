package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 描述：Number668Test
 *
 * @author dinglevin
 * @since 2021/6/19 15:14 周六
 */
public class Number0668Test {
    private Number0668 executor = new Number0668();

    @Test
    public void testVersion1FindKthNumber() {
        assertEquals(31666344, executor.version1FindKthNumber(9895, 28405, 100787757));
        assertEquals(3, executor.version1FindKthNumber(3, 1, 3));
        assertEquals(3, executor.version1FindKthNumber(3, 3, 5));
        assertEquals(6, executor.version1FindKthNumber(2, 3, 6));
    }

    @Test
    public void testVersion2FindKthNumber() {
        assertEquals(3, executor.version2FindKthNumber(3, 3, 5));
        assertEquals(3, executor.version2FindKthNumber(3, 1, 3));
        assertEquals(6, executor.version2FindKthNumber(2, 3, 6));
        assertEquals(31666344, executor.version2FindKthNumber(9895, 28405, 100787757));
    }

    @Test
    public void testVersion3FindKthNumber() {
        assertEquals(3, executor.version3FindKthNumber(3, 3, 5));
        assertEquals(3, executor.version3FindKthNumber(3, 1, 3));
        assertEquals(6, executor.version3FindKthNumber(2, 3, 6));
        assertEquals(31666344, executor.version3FindKthNumber(9895, 28405, 100787757));
    }
}
