package com.dinglevin.algorithm.others;

/**
 * 描述：ListReverse
 *
 * @author dinglevin
 * @since 2021/6/15 10:45 周二
 */
public class ListReverse {
    public ListNode execute(ListNode header) {
        if (header == null) {
            return null;
        }

        ListNode prev = header;
        ListNode current = header.next;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        header.next = null;
        return prev;
    }

    public static class ListNode {
        int value;
        ListNode next;

        ListNode() {
        }

        ListNode(int value) {
            this.value = value;
        }

        ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
