package com.dinglevin.algorithm.leetcode;

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
            if (head.next == null && n > 0) {
                return null;
            }

            ListNode p = head, q = null;
            int distance = 0;
            while (p != null) {
                if (distance < n) {
                    p = p.next;
                    distance++;
                } else {
                    p = p.next;
                    q = (q == null) ? head : q.next;
                }
            }

            if (distance >= n) {
                if (q == null) {
                    return head.next;
                }

                ListNode cur = q;
                if (q.next != null) {
                    cur.next = q.next.next;
                } else {
                    cur.next = null;
                }
            }

            return head;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
