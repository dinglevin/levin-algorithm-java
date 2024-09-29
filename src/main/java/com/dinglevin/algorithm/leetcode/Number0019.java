package com.dinglevin.algorithm.leetcode;

import com.dinglevin.algorithm.model.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 
 * @author dinglevin
 * @since 2024-09-22 14:53:34
 */
public class Number0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return new Version1().invoke(head, n);
    }

    public static class Version1 {
        public ListNode invoke(ListNode head, int n) {
            if (head.getNext() == null && n > 0) {
                return null;
            }

            ListNode p = head, q = null;
            int distance = 0;
            while (p != null) {
                if (distance < n) {
                    p = p.getNext();
                    distance++;
                } else {
                    p = p.getNext();
                    q = (q == null) ? head : q.getNext();
                }
            }

            if (distance >= n) {
                if (q == null) {
                    return head.getNext();
                }

                ListNode cur = q;
                if (q.getNext() != null) {
                    cur.setNext(q.getNext().getNext());
                } else {
                    cur.setNext(null);
                }
            }

            return head;
        }
    }
}
