package com.leetcode.linkedlist;

/**
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution_21 {
    //    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode pre = new ListNode(0);
//        ListNode temp = pre;
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                temp.next = l1;
//                l1 = l1.next;
//            } else {
//                temp.next = l2;
//                l2 = l2.next;
//            }
//            temp = temp.next;
//        }
//
//        if (l1 != null) {
//            temp.next = l1;
//        }
//        if (l2 != null) {
//            temp.next = l2;
//        }
//        return pre.next;
//    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
