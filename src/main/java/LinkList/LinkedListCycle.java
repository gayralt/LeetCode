package main.java.LinkList;

/**
 * Given a linked list, determine if it has a cycle in it.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 *
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode faster;
        ListNode lower;
        if (null==head)
            return false;
        faster=lower=head;
        while (null!=faster&&null!=faster.next&&null!=lower){
            faster=faster.next.next;
            lower=lower.next;
            if (faster==lower)
                return true;
        }
        return false;
    }
}
