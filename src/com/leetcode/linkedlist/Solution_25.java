package com.leetcode.linkedlist;

import java.sql.Statement;
import java.util.List;
import java.util.Stack;

public class Solution_25 {
    /**
     * 将链表分为已逆序--待逆序--未逆序
     * 按顺序从链表中截取长度为 k 的子链表 M 不足 k 时解题完成
     * 记录 子链表的开始节点 start和结束节点 end 并将 end 的后继节点置为 null
     * 调用reverseList方法将子链表逆序，并将返回的值赋给pre.next
     * end的后继节点赋值给start的后继节点
     *
     * @param head
     * @param k
     * @return
     */
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode pre = dummy;
//        ListNode end = dummy;
//        while (end.next != null) {
//            for (int i = 0; i < k && end != null; i++) {
//                end = end.next;
//            }
//            if (end == null) {
//                break;
//            }
//            ListNode start = pre.next;
//            ListNode next = end.next;
//            end.next = null;
//            pre.next = reverseList(start);
//            start.next = next;
//            pre = start;
//            end = pre;
//        }
//        return dummy.next;
//    }
//
//    public ListNode reverseList(ListNode head) {
//
//        ListNode pre = null;
//        ListNode currentNode = head;
//        while (currentNode != null) {
//            ListNode next = currentNode.next;
//            currentNode.next = pre;
//            pre = currentNode;
//            currentNode = next;
//        }
//        return pre;
//    }
    //使用栈的方式
//    public ListNode reverseKGroup(ListNode head, int k) {
//        Stack<ListNode> stack = new Stack<>();
//        ListNode pre = new ListNode(0);
//        pre.next = head;
//        ListNode temp = pre;
//        while (temp.next != null) {
//            ListNode start = temp;
//            int i = 0;
//            ListNode newStart = null;
//            for (; i < k && temp.next != null; i++) {
//                temp = temp.next;
//                stack.push(temp);
//            }
//            ListNode end = temp.next;
//            if (end == null && i < k) break;
//            while (!stack.empty()) {
//                start.next = stack.pop();
//                start = start.next;
//            }
//            start.next = end;
//            temp = start;
//        }
//        return pre.next;
//    }

    //提交时间为0ms的方法
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode[] tempNodes = new ListNode[k+1];
//        tempNodes[0] = head;
//        for (int i = 1; i < k+1; i++) {
//            if (tempNodes[i-1] == null) {
//                return head;
//            }
//            tempNodes[i] = tempNodes[i-1].next;
//        }
//
//        for (int j = k-1; j > 0; j--) {
//            tempNodes[j].next = tempNodes[j-1];
//        }
//        tempNodes[0].next = reverseKGroup(tempNodes[k], k);
//
//        return tempNodes[k-1];
//    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode[] tempNode = new ListNode[k + 1];
        tempNode[0] = head;
        for (int i = 0; i < k; i++) {
            if (tempNode[i] == null) {
                return head;
            }
            tempNode[i + 1] = tempNode[i].next;
        }
        for (int j = k - 1; j > 0; j--) {
            tempNode[j].next = tempNode[j - 1];
        }
        tempNode[0].next = reverseKGroup(tempNode[k], k);
        return tempNode[k - 1];
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        Solution_25 solution_25 = new Solution_25();
        System.out.println(solution_25.reverseKGroup(listNode, 2));
    }
}
