package com.leetcode.linkedlist;

/**
 * 82. 删除排序链表中的重复元素 II
 * <p>
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class Solution_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = head.next;
        while (second != null) {
            boolean isRepeat = false;
            while (second != null && first.next.val == second.val) {
                isRepeat = true;
                second = second.next;
            }
            if (isRepeat) {
                first.next = second;
            }
            if (second != null && first.next.val != second.val) {
                first = first.next;
            }
        }
        return dummy.next;
    }
}
