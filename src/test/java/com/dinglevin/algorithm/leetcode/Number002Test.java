package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class Number002Test {
    @Test
    public void testAddTwoNumbersV0() {
        ListNode result = Number002.addTwoNumbersV0(create(new int[] { 2, 4, 3 }),
                create(new int[] { 5, 6, 4 }));
        assertEquals(Lists.newArrayList(7, 0, 8), convertToList(result));

        result = Number002.addTwoNumbersV0(create(new int[] { 0 }), create(new int[] { 0 }));
        assertEquals(Lists.newArrayList(0), convertToList(result));

        result = Number002.addTwoNumbersV0(create(new int[] { 9, 9, 9, 9, 9, 9, 9 }),
                create(new int[] { 9, 9, 9, 9 }));
        assertEquals(Lists.newArrayList(8, 9, 9, 9, 0, 0, 0, 1), convertToList(result));
    }

    @Test
    public void testAddTwoNumbersV1() {
        ListNode result = Number002.addTwoNumbersV1(create(new int[] { 2, 4, 3 }),
                create(new int[] { 5, 6, 4 }));
        assertEquals(Lists.newArrayList(7, 0, 8), convertToList(result));

        result = Number002.addTwoNumbersV0(create(new int[] { 0 }), create(new int[] { 0 }));
        assertEquals(Lists.newArrayList(0), convertToList(result));

        result = Number002.addTwoNumbersV0(create(new int[] { 9, 9, 9, 9, 9, 9, 9 }),
                create(new int[] { 9, 9, 9, 9 }));
        assertEquals(Lists.newArrayList(8, 9, 9, 9, 0, 0, 0, 1), convertToList(result));
    }

    private ListNode create(int[] numbers) {
        ListNode head = new ListNode(numbers[0]);
        ListNode tail = head;
        for (int i = 1; i < numbers.length; i++) {
            tail.next = new ListNode(numbers[i]);
            tail = tail.next;
        }
        return head;
    }

    private List<Integer> convertToList(ListNode list) {
        List<Integer> result = Lists.newArrayList();
        while (list != null) {
            result.add(list.val);
            list = list.next;
        }
        return result;
    }
}
