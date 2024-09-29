/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
package com.dinglevin.algorithm.leetcode;

import com.dinglevin.algorithm.model.ListNode;

public class Number0002 {
    private Number0002() {
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return new Version1().invoke(l1, l2);
        // return new Version2().invoke(l1, l2);
    }

    public static class Version1 {
        public ListNode invoke(ListNode l1, ListNode l2) {
            ListNode p1 = l1;
            ListNode p2 = l2;

            ListNode head = new ListNode();
            ListNode cur = head;
            int carrier = 0;
            while (p1 != null || p2 != null) {
                int sum = carrier;
                if (p1 != null) {
                    sum += p1.getVal();
                    p1 = p1.getNext();
                }
                if (p2 != null) {
                    sum += p2.getVal();
                    p2 = p2.getNext();
                }

                cur.setNext(new ListNode(sum % 10));
                carrier = sum / 10;
                cur = cur.getNext();
            }
            if (carrier > 0) {
                cur.setNext(new ListNode(carrier));
            }

            return head.getNext();
        }
    }

    public static class Version2 {
        public ListNode invoke(ListNode l1, ListNode l2) {
            ListNode header = new ListNode();
            ListNode p = header;
            int overflow = 0;
            while (l1 != null && l2 != null) {
                int result = l1.getVal() + l2.getVal() + overflow;
                overflow = (result >= 10 ? 1 : 0);

                p.setNext(new ListNode(result % 10));
                p = p.getNext();
                l1 = l1.getNext();
                l2 = l2.getNext();
            }

            p.setNext(l1 == null ? l2 : l1);
            if (overflow != 0) {
                if (p.getNext() == null) {
                    p.setNext(new ListNode(overflow));
                } else {
                    while (overflow != 0 && p.getNext() != null) {
                        p.getNext().setVal(p.getNext().getVal() + overflow);
                        overflow = (p.getNext().getVal() >= 10 ? 1 : 0);
                        if (p.getNext().getVal() >= 10) {
                            p.getNext().setVal(p.getNext().getVal() - 10);
                        }
                        p = p.getNext();
                    }
                    if (overflow != 0) {
                        p.setNext(new ListNode(overflow));
                    }
                }
            }

            return header.getNext();
        }
    }
}
