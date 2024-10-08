package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0027Test {
    @Test
    public void testVersion1() {
        int[] nums = new int[] { 3,2,2,3 };
        assertEquals(2, new Number0027.Version1().invoke(nums, 3));
        assertEquals(2, nums[0]);
        assertEquals(2, nums[1]);

        nums = new int[] { 0,1,2,2,3,0,4,2 };
        assertEquals(5, new Number0027.Version1().invoke(nums, 2));
        assertEquals(0, nums[0]);
        assertEquals(1, nums[1]);
        assertEquals(3, nums[2]);
        assertEquals(0, nums[3]);
        assertEquals(4, nums[4]);
    }
}
