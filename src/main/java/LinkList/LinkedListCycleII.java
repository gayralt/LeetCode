package main.java.LinkList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 */
public class LinkedListCycleII {

    /**
     * 论坛解法，当判断为循环链表时 需要经过数学推导
     * 自己尝试计算推导
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode node=head;
        if (null==node||null==node.next)
            return null;
        Set<ListNode> set=new HashSet<>();
        while (null!=node.next){
            //每次加入,先加入set
            set.add(node);
            //如果下一个结点已存在，返回该结点
            if (set.contains(node.next)){
                return node.next;
            }
            node=node.next;
        }
        return null;
    }
}
