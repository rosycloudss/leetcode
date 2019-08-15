package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_141 {
    //使用set判断重复
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> tempSet = new HashSet<>();
//        while (head != null && !tempSet.contains(head)) {
//            tempSet.add(head);
//            head = head.next;
//        }
//        return head != null;
//    }
    //使用map
//    public boolean hasCycle(ListNode head) {
//        Map<ListNode,Integer> tempMap = new HashMap<>();
//        while (head != null && tempMap.get(head) != null) {
//            tempMap.put(head,0);
//            head = head.next;
//        }
//        return head != null;
//    }

    //快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

//    public static void main(String[] args) {
//        Solution_141 solution_141 = new Solution_141();
//        solution_141.hasCycle(new ListNode(0));
//    }

