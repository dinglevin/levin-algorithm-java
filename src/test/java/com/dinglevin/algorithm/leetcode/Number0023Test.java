package com.dinglevin.algorithm.leetcode;

import static com.dinglevin.algorithm.common.ListNodeUtils.convertToList;
import static com.dinglevin.algorithm.common.ListNodeUtils.buildList;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.dinglevin.algorithm.model.ListNode;

public class Number0023Test {
    @Test
    public void testVersion1() {
        assertEquals(Arrays.asList(1, 1, 2, 3, 4, 4, 5, 6),
                convertToList(new Number0023.Version1().invoke(new ListNode[] {
                        buildList(new int[] { 1, 4, 5 }),
                        buildList(new int[] { 1, 3, 4 }),
                        buildList(new int[] { 2, 6 })
                })));
        assertEquals(Arrays.asList(),
                convertToList(new Number0023.Version1().invoke(new com.dinglevin.algorithm.model.ListNode[0])));
        assertEquals(Arrays.asList(), convertToList(new Number0023.Version1().invoke(new ListNode[] {
                buildList(new int[0])
        })));
    }

    @Test
    public void testVersion2() {
        assertEquals(Arrays.asList(1, 1, 2, 3, 4, 4, 5, 6),
                convertToList(new Number0023.Version2().invoke(new ListNode[] {
                        buildList(new int[] { 1, 4, 5 }),
                        buildList(new int[] { 1, 3, 4 }),
                        buildList(new int[] { 2, 6 })
                })));
        assertEquals(Arrays.asList(), convertToList(new Number0023.Version2().invoke(new ListNode[0])));
        assertEquals(Arrays.asList(), convertToList(new Number0023.Version2().invoke(new ListNode[] {
                buildList(new int[0])
        })));
    }

    @Test
    public void testVersion3() {
        assertEquals(Arrays.asList(1, 1, 2, 3, 4, 4, 5, 6),
                convertToList(new Number0023.Version3().invoke(new ListNode[] {
                        buildList(new int[] { 1, 4, 5 }),
                        buildList(new int[] { 1, 3, 4 }),
                        buildList(new int[] { 2, 6 })
                })));
        assertEquals(Arrays.asList(), convertToList(new Number0023.Version3().invoke(new ListNode[0])));
        assertEquals(Arrays.asList(), convertToList(new Number0023.Version3().invoke(new ListNode[] {
                buildList(new int[0])
        })));
    }

    @Test
    public void testVersion4() {
        assertEquals(Arrays.asList(1, 1, 2, 3, 4, 4, 5, 6),
                convertToList(new Number0023.Version4().invoke(new ListNode[] {
                        buildList(new int[] { 1, 4, 5 }),
                        buildList(new int[] { 1, 3, 4 }),
                        buildList(new int[] { 2, 6 })
                })));
        assertEquals(Arrays.asList(), convertToList(new Number0023.Version4().invoke(new ListNode[0])));
        assertEquals(Arrays.asList(), convertToList(new Number0023.Version4().invoke(new ListNode[] {
                buildList(new int[0])
        })));
    }
}
