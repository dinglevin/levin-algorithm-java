package com.dinglevin.algorithm.leetcode;

import com.dinglevin.algorithm.model.ListNode;

/**
 * 描述：Number25
 *
 * @author dinglevin
 * @since 2021/6/13 18:45 周日
 */
public class Number0025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        OneResult result = doReverse(head, k);
        ListNode newHead = result.start;
        ListNode prevEnd = result.end;
        while (result.end.getNext() != null) {
            result = doReverse(result.end.getNext(), k);
            if (result.full) {
                prevEnd.setNext(result.start);
                prevEnd = result.end;
            }
        }
        if (!result.full) {
            result = doReverse(result.start, k);
            prevEnd.setNext(result.start);
        }
        return newHead;
    }

    protected OneResult doReverse(ListNode start, int k) {
        int len = 1;
        ListNode prev = start;
        ListNode current = start.getNext();
        while (current != null && len < k) {
            ListNode next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            len++;
        }

        start.setNext(current);
        boolean full = false;
        if (len == k) {
            full = true;
        }
        return new OneResult(prev, start, full);
    }

    public static class OneResult {
        ListNode start;
        ListNode end;
        boolean full;

        public OneResult(ListNode start, ListNode end, boolean full) {
            this.start = start;
            this.end = end;
            this.full = full;
        }
    }
}
