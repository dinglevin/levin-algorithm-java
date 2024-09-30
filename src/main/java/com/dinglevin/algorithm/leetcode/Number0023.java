package com.dinglevin.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * 23. 合并 K 个升序链表
 * 
 * @author dinglevin
 * @since 2024-09-27 22:52:57
 */
public class Number0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        return new Version1().invoke(lists);
    }

    public static class Version1 {
        public ListNode invoke(ListNode[] lists) {
            ListNode head = new ListNode();

            ListNode p = head;
            while (true) {
                int index = findMin(lists);
                if (index < 0) {
                    break;
                }
                p.next = lists[index];
                p = p.next;
                lists[index] = lists[index].next;
            }

            return head.next;
        }

        private int findMin(ListNode[] lists) {
            int min = Integer.MAX_VALUE;
            int result = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }

                if (lists[i].val < min) {
                    result = i;
                    min = lists[i].val;
                }
            }
            return result;
        }
    }

    public static class Version2 {
        public ListNode invoke(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            ListNode ans = null;
            for (int i = 0; i < lists.length; i++) {
                ans = merge(ans, lists[i]);
            }
            return ans;
        }
    }

    public static class Version3 {
        public ListNode invoke(ListNode[] lists) {
            return mergeKList(lists, 0, lists.length - 1);
        }

        private ListNode mergeKList(ListNode[] lists, int start, int end) {
            if (start == end) {
                return lists[start];
            }

            if (start > end) {
                return null;
            }

            int mid = (start + end) / 2;
            return merge(mergeKList(lists, start, mid), mergeKList(lists, mid + 1, end));
        }
    }

    public static class Version4 {
        private static class Holder implements Comparable<Holder> {
            int val;
            ListNode node;

            public Holder(int val, ListNode node) {
                this.val = val;
                this.node = node;
            }

            @Override
            public int compareTo(Holder o) {
                return val - o.val;
            }
        }

        public ListNode invoke(ListNode[] lists) {
            PriorityQueue<Holder> queue = new PriorityQueue<>();
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    queue.offer(new Holder(lists[i].val, lists[i]));
                }
            }

            ListNode head = new ListNode();
            ListNode tail = head;
            while (!queue.isEmpty()) {
                Holder holder = queue.poll();
                tail.next = (holder.node);
                tail = tail.next;
                if (holder.node.next != null) {
                    queue.offer(new Holder(holder.node.next.val, holder.node.next));
                }
            }

            return head.next;
        }
    }

    private static ListNode merge(ListNode p, ListNode q) {
        if (p == null || q == null) {
            return p == null ? q : p;
        }

        ListNode head = new ListNode();
        ListNode tail = head;
        while (p != null && q != null) {
            if (p.val > q.val) {
                tail.next = q;
                q = q.next;
            } else {
                tail.next = p;
                p = p.next;
            }
            tail = tail.next;
        }
        tail.next = (p == null ? q : p);
        return head.next;
    }
}
