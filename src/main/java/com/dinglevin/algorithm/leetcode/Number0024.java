package com.dinglevin.algorithm.leetcode;

/**
 * 24. 两两交换链表中的节点
 * 
 * @author dinglevin
 * @since 2024-09-30 22:58:38
 */
public class Number0024 {
    public ListNode swapPairs(ListNode head) {
        return new Version1().invoke(head);
    }

    public static class Version1 {
        public ListNode invoke(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode prev = new ListNode();
            prev.next = head;
            head = prev;

            ListNode p = prev.next;
            ListNode q = p.next;
            while (p != null && q != null) {
                prev.next = p.next;
                q = q.next;
                prev.next.next = p;
                p.next = q;
                prev = p;

                if (q != null) {
                    p = q;
                    q = q.next;
                }
            }

            return head.next;
        }
    }
}
