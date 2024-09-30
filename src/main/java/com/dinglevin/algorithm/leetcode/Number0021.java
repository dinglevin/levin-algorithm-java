package com.dinglevin.algorithm.leetcode;

/**
 * 描述：Number21
 *
 * @author dinglevin
 * @since 2021/6/20 17:22 周日
 */
public class Number0021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = null;
        ListNode p = null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        if (p1.val < p2.val) {
            p = p1;
            p1 = p1.next;
        } else {
            p = p2;
            p2 = p2.next;
        }
        result = p;

        while (p1 != null || p2 != null) {
            if (p1 == null) {
                p.next = p2;
                p2 = p2.next;
            } else if (p2 == null) {
                p.next = p1;
                p1 = p1.next;
            } else if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        return result;
    }
}
