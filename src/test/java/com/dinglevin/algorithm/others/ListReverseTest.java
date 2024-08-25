package com.dinglevin.algorithm.others;

import org.junit.Test;

/**
 * 描述：ListReverseTest
 *
 * @author dinglevin
 * @since 2021/6/15 11:02 周二
 */
public class ListReverseTest {
    private ListReverse listReverse = new ListReverse();

    @Test
    public void testExecute() {
        ListReverse.ListNode header1 = build1Node();
        printList(listReverse.execute(header1));

        ListReverse.ListNode header2 = build2Node();
        printList(listReverse.execute(header2));

        ListReverse.ListNode header3 = build5Node();
        printList(listReverse.execute(header3));
    }

    private void printList(ListReverse.ListNode header) {
        ListReverse.ListNode node = header;
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    private ListReverse.ListNode build1Node() {
        ListReverse.ListNode header = new ListReverse.ListNode(10);
        return header;
    }

    private ListReverse.ListNode build2Node() {
        ListReverse.ListNode header = new ListReverse.ListNode(10);
        header.next = new ListReverse.ListNode(20);
        return header;
    }

    private ListReverse.ListNode build5Node() {
        ListReverse.ListNode header = new ListReverse.ListNode(10);
        header.next = new ListReverse.ListNode(20);
        header.next.next = new ListReverse.ListNode(30);
        header.next.next.next = new ListReverse.ListNode(40);
        header.next.next.next.next = new ListReverse.ListNode(50);
        return header;
    }
}
