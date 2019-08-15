package com.leetcode.linkedlist;

import javax.xml.transform.SourceLocator;

public class Solution_24 {
    //非递归
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode currentNode = head;
        head = pre;
        while (currentNode != null && currentNode.next != null) {
            ListNode temp = currentNode.next.next;
            if (pre != null) {
                pre.next = currentNode.next;
            }
            pre = currentNode;
            currentNode.next.next = currentNode;
            currentNode.next = temp;
            currentNode = temp;
        }
        return head.next;
    }

    //递归解法

//    public ListNode swapPairs(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//
//        ListNode next = head.next;
//        head.next = swapPairs(next.next);
//        next.next = head;
//        return next;
//    }


}
