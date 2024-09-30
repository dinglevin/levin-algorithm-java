package com.dinglevin.algorithm.leetcode;

/**
 * 描述：Number92
 *
 * @author dinglevin
 * @since 2021/6/20 17:40 周日
 */
public class Number0092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        if (left == right) {
            return head;
        }

        ListNode prev = null;
        ListNode start = null;
        ListNode p = head;
        int i = 0;
        while (p != null) {
            if (i == left - 1) {
                start = p;
                break;
            } else {
                prev = p;
                p = p.next;
            }
            i++;
        }
        if (start == null) {
            return head;
        }

        ListNode p1 = start;
        ListNode p2 = start.next;
        i++;
        while (p2 != null) {
            if (i == right - 1) {
                break;
            }

            ListNode temp = p1;
            p1 = p2;
            p2 = p2.next;
            p1.next = temp;
            i++;
        }
        if (p2 != null) {
            ListNode temp = p1;
            p1 = p2;
            p2 = p2.next;
            p1.next = temp;
            if (prev != null) {
                prev.next = p1;
            }
            start.next = p2;
        }

        return prev == null ? p1 : head;
    }
}
