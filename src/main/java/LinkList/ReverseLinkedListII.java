package main.java.LinkList;

import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
       if (head==null||head.next==null)
           return head;
       //定义当前点的前一个点
       ListNode newHead=new ListNode(0);
       newHead.next=head;
       ListNode nextNode;
       ListNode preNode=newHead;
       ListNode nowNode=head;
       //循环
       for (int i=1;nowNode.next!=null;i++){
           //符合条件时再逆置
           if (i>=m&&i<n){
               //逆置操作
               nextNode=nowNode.next;
               nowNode.next=nextNode.next;
               nextNode.next=preNode.next;
               //逆置区域的头结点
               preNode.next=nextNode;
           }else{
               //不逆置则下一个
               nowNode=nowNode.next;
               preNode=preNode.next;
           }
       }
        return newHead.next;
    }
}
