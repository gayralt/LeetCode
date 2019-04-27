package main.java.LinkList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first;
        ListNode second;
        ListNode node;
        ListNode head;
        //判空
        if (null==l1&&null==l2)
            return null;
        else if (null==l1)
            return l2;
        else if (null==l2)
            return l1;
        if (l1.val<=l2.val) {
            first = l1;
            second=l2;
            head=l1;
        }
        else {
            first=l2;
            second = l1;
            head=l2;
        }
        while (null!=first.next&&null!=second){
            //满足插入条件
            if (second.val>=first.val&&second.val<=first.next.val){
                node=second;
                second=second.next;
                node.next=first.next;
                first.next=node;
            }
            first=first.next;
        }
       if (null!=second)
           first.next=second;
        return head;
    }
}
