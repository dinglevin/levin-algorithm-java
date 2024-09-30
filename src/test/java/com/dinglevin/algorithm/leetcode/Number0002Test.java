package com.dinglevin.algorithm.leetcode;

import static com.dinglevin.algorithm.common.ListNodeUtils.convertToList;
import static com.dinglevin.algorithm.common.ListNodeUtils.buildList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.Lists;

public class Number0002Test {
        @Test
        public void testAddTwoNumbersV1() {
                ListNode result = new Number0002.Version1().invoke(buildList(new int[] { 2, 4, 3 }),
                                buildList(new int[] { 5, 6, 4 }));
                assertEquals(Lists.newArrayList(7, 0, 8), convertToList(result));

                result = new Number0002.Version1().invoke(buildList(new int[] { 0 }), buildList(new int[] { 0 }));
                assertEquals(Lists.newArrayList(0), convertToList(result));

                result = new Number0002.Version1().invoke(buildList(new int[] { 9, 9, 9, 9, 9, 9, 9 }),
                                buildList(new int[] { 9, 9, 9, 9 }));
                assertEquals(Lists.newArrayList(8, 9, 9, 9, 0, 0, 0, 1), convertToList(result));
        }

        @Test
        public void testAddTwoNumbersV2() {
                ListNode result = new Number0002.Version2().invoke(buildList(new int[] { 2, 4, 3 }),
                                buildList(new int[] { 5, 6, 4 }));
                assertEquals(Lists.newArrayList(7, 0, 8), convertToList(result));

                result = new Number0002.Version2().invoke(buildList(new int[] { 0 }),
                                buildList(new int[] { 0 }));
                assertEquals(Lists.newArrayList(0), convertToList(result));

                result = new Number0002.Version2().invoke(buildList(new int[] { 9, 9, 9, 9, 9, 9, 9 }),
                                buildList(new int[] { 9, 9, 9, 9 }));
                assertEquals(Lists.newArrayList(8, 9, 9, 9, 0, 0, 0, 1), convertToList(result));
        }
}
