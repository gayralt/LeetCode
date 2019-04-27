package main.java.LinkList;
/**
 * Definition for singly-linked list.
 *   public class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode(int x) { val = x; }
 *   }
 */
/**
 * Delete Node in a Linked List
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Given linked list -- head = [4,5,1,9], which looks like following:
 */

/**
 * 只对该结点进行操作
 * 可以将下一个结点的值赋值给当前
 * 并删除下一个结点来达到删除该结点的目的
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
            node.val=node.next.val;
            node.next=node.next.next;
    }
}
