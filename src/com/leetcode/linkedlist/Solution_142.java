package com.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Solution_142 {
//    public ListNode detectCycle(ListNode head) {
//        Set<ListNode> tempSet = new HashSet<>();
//        while (head != null && !tempSet.contains(head)) {
//            tempSet.add(head);
//            head = head.next;
//        }
//        return head;
//    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode intersenct = getIntersect(head);
        if(intersenct == null){
            return null;
        }
        while(head != intersenct){
            head = head.next;
            intersenct = intersenct.next;
        }
        return head;
    }

    public ListNode getIntersect(ListNode head){

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return fast;
            }
        }
        return null;
    }
}
