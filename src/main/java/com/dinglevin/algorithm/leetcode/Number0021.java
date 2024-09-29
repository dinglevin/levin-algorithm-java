package com.dinglevin.algorithm.leetcode;

import com.dinglevin.algorithm.model.ListNode;

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
        if (p1.getVal() < p2.getVal()) {
            p = p1;
            p1 = p1.getNext();
        } else {
            p = p2;
            p2 = p2.getNext();
        }
        result = p;

        while (p1 != null || p2 != null) {
            if (p1 == null) {
                p.setNext(p2);
                p2 = p2.getNext();
            } else if (p2 == null) {
                p.setNext(p1);
                p1 = p1.getNext();
            } else if (p1.getVal() < p2.getVal()) {
                p.setNext(p1);
                p1 = p1.getNext();
            } else {
                p.setNext(p2);
                p2 = p2.getNext();
            }
            p = p.getNext();
        }

        return result;
    }
}
