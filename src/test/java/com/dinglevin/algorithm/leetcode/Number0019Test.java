package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class Number0019Test {
    @Test
    public void testVersion1() {
        assertEquals(Arrays.asList(2), convertToList(
            new Number0019.Version1().invoke(create(new int[] { 1,2 }), 2)));
        assertEquals(Arrays.asList(1,2,3,5), convertToList(
            new Number0019.Version1().invoke(create(new int[] { 1,2,3,4,5 }), 2)));
        assertEquals(Arrays.asList(1,2,3,4), convertToList(
            new Number0019.Version1().invoke(create(new int[] { 1,2,3,4,5 }), 1)));
        assertEquals(Arrays.asList(), convertToList(
            new Number0019.Version1().invoke(create(new int[] { 1 }), 1)));
    }

    private Number0019.ListNode create(int[] numbers) {
        Number0019.ListNode head = new Number0019.ListNode(numbers[0]);
        Number0019.ListNode tail = head;
        for (int i = 1; i < numbers.length; i++) {
            tail.next = new Number0019.ListNode(numbers[i]);
            tail = tail.next;
        }
        return head;
    }

    private List<Integer> convertToList(Number0019.ListNode list) {
        List<Integer> result = Lists.newArrayList();
        while (list != null) {
            result.add(list.val);
            list = list.next;
        }
        return result;
    }
}
