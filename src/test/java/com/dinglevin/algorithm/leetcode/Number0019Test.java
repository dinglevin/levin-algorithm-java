package com.dinglevin.algorithm.leetcode;

import static com.dinglevin.algorithm.common.ListNodeUtils.convertToList;
import static com.dinglevin.algorithm.common.ListNodeUtils.buildList;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Number0019Test {
    @Test
    public void testVersion1() {
        assertEquals(Arrays.asList(2), convertToList(
                new Number0019.Version1().invoke(buildList(new int[] { 1, 2 }), 2)));
        assertEquals(Arrays.asList(1, 2, 3, 5), convertToList(
                new Number0019.Version1().invoke(buildList(new int[] { 1, 2, 3, 4, 5 }), 2)));
        assertEquals(Arrays.asList(1, 2, 3, 4), convertToList(
                new Number0019.Version1().invoke(buildList(new int[] { 1, 2, 3, 4, 5 }), 1)));
        assertEquals(Arrays.asList(), convertToList(
                new Number0019.Version1().invoke(buildList(new int[] { 1 }), 1)));
    }
}
