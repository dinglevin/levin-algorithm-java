package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class Number0002Test {
    @Test
    public void testAddTwoNumbersV1() {
        Number0002.ListNode result = new Number0002.Version1().invoke(create(new int[] { 2, 4, 3 }),
                create(new int[] { 5, 6, 4 }));
        assertEquals(Lists.newArrayList(7, 0, 8), convertToList(result));

        result = new Number0002.Version1().invoke(create(new int[] { 0 }), create(new int[] { 0 }));
        assertEquals(Lists.newArrayList(0), convertToList(result));

        result = new Number0002.Version1().invoke(create(new int[] { 9, 9, 9, 9, 9, 9, 9 }),
                create(new int[] { 9, 9, 9, 9 }));
        assertEquals(Lists.newArrayList(8, 9, 9, 9, 0, 0, 0, 1), convertToList(result));
    }

    @Test
    public void testAddTwoNumbersV2() {
        Number0002.ListNode result = new Number0002.Version2().invoke(create(new int[] { 2, 4, 3 }),
                create(new int[] { 5, 6, 4 }));
        assertEquals(Lists.newArrayList(7, 0, 8), convertToList(result));

        result = new Number0002.Version2().invoke(create(new int[] { 0 }), create(new int[] { 0 }));
        assertEquals(Lists.newArrayList(0), convertToList(result));

        result = new Number0002.Version2().invoke(create(new int[] { 9, 9, 9, 9, 9, 9, 9 }),
                create(new int[] { 9, 9, 9, 9 }));
        assertEquals(Lists.newArrayList(8, 9, 9, 9, 0, 0, 0, 1), convertToList(result));
    }

    private Number0002.ListNode create(int[] numbers) {
        Number0002.ListNode head = new Number0002.ListNode(numbers[0]);
        Number0002.ListNode tail = head;
        for (int i = 1; i < numbers.length; i++) {
            tail.next = new Number0002.ListNode(numbers[i]);
            tail = tail.next;
        }
        return head;
    }

    private List<Integer> convertToList(Number0002.ListNode list) {
        List<Integer> result = Lists.newArrayList();
        while (list != null) {
            result.add(list.val);
            list = list.next;
        }
        return result;
    }
}
