package com.dinglevin.algorithm.others;

import com.dinglevin.algorithm.model.ListNode;

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
        ListNode current = header.getNext();
        while (current != null) {
            ListNode next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        header.setNext(null);
        return prev;
    }
}
