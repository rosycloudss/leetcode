package com.leetcode.linkedlist;

/*
19. 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

 */
public class Solution_19 {
    /**
     * 遍历两次
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        length = length - n;
        ListNode pre = new ListNode(0);
        pre.next = head;
        temp = pre;
        if (length >= 0) {
            while (length > 0) {
                temp = temp.next;
                length--;
            }
            temp.next = temp.next.next;
            return pre.next;
        } else {
            return head;
        }
    }



//    /**
//     * 遍历一次
//     * 使用快慢两个指针其中快指针和慢指针相差 n 个节点，当快指针遍历结束后，慢指针的下一个就是要删除的节点
//     *
//     * @param head
//     * @param n
//     * @return
//     */
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode pre = new ListNode(0);
//        pre.next = head;
//        ListNode slow = pre;
//        ListNode fast = head;
//        int k = n;
//        while (fast != null) {
//            if (k == 0) {
//                slow = slow.next;
//            } else {
//                k--;
//            }
//            fast = fast.next;
//        }
//        if (slow != null && slow.next != null) {
//            slow.next = slow.next.next;
//        }
//        return pre.next;
//    }
    }
