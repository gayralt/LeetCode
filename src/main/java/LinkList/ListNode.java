package main.java.LinkList;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目：给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */

/**
 * 解法：快慢指针法，一个指针指向的速度是另一个的两倍
 * 这样当一个指向末尾时，另一个刚好在中间
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}