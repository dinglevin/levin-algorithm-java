package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 描述：Number41Test
 *
 * @author dinglevin
 * @since 2021/6/18 13:54 周五
 */
public class Number0041Test {
    private Number0041 executor = new Number0041();

    @Test
    public void testVersion1FirstMissingPositive() {
        int[] nums = new int[] { 1, 2, 0 };
        assertEquals(3, executor.version1FirstMissingPositive(nums));

        nums = new int[] { 3, 4, -1, 1 };
        assertEquals(2, executor.version1FirstMissingPositive(nums));

        nums = new int[] { 7, 8, 9, 11, 12 };
        assertEquals(1, executor.version1FirstMissingPositive(nums));

        nums = new int[] { 1 };
        assertEquals(2, executor.version1FirstMissingPositive(nums));

        nums = new int[] { 1, 1 };
        assertEquals(2, executor.version1FirstMissingPositive(nums));
    }

    @Test
    public void testVersion2FirstMissingPositive() {
        int[] nums = new int[] { 1, 2, 0 };
        assertEquals(3, executor.version2FirstMissingPositive(nums));

        nums = new int[] { 3, 4, -1, 1 };
        assertEquals(2, executor.version2FirstMissingPositive(nums));

        nums = new int[] { 7, 8, 9, 11, 12 };
        assertEquals(1, executor.version2FirstMissingPositive(nums));

        nums = new int[] { 1 };
        assertEquals(2, executor.version2FirstMissingPositive(nums));

        nums = new int[] { 1, 1 };
        assertEquals(2, executor.version2FirstMissingPositive(nums));
    }
}
