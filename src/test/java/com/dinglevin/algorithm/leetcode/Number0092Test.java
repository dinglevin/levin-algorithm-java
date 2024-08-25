package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 描述：Number92Test
 *
 * @author dinglevin
 * @since 2021/6/20 18:17 周日
 */
public class Number0092Test {
    private Number0092 executor = new Number0092();

    @Test
    public void testReverseBetween() {
        Number0092.ListNode head = buildList(new int[] { 1, 2, 3, 4, 5 });
        // assertEquals(Arrays.asList(1, 4, 3, 2, 5),
        // toIntArray(executor.reverseBetween(head, 2, 4)));

        head = buildList(new int[] { 3, 5 });
        // assertEquals(Arrays.asList(5, 3), toIntArray(executor.reverseBetween(head, 1,
        // 2)));

        head = buildList(new int[] { 3, 5 });
        assertEquals(Arrays.asList(3, 5), toIntArray(executor.reverseBetween(head, 1, 1)));
    }

    private List<Integer> toIntArray(Number0092.ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    private Number0092.ListNode buildList(int[] array) {
        Number0092.ListNode head = null, p = null;
        for (int i = 0; i < array.length; i++) {
            if (head == null) {
                head = new Number0092.ListNode(array[i]);
                p = head;
            } else {
                p.next = new Number0092.ListNode(array[i]);
                p = p.next;
            }
        }
        return head;
    }
}
