package main.java.LinkList;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 在排好序的链表中删除重复的结点
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        //判空
        if (null==head)
            return head;
        ListNode node=head;
        while (null!=node.next){
            //删除下一个结点
            if (node.val==node.next.val){
                node.next=node.next.next;
                continue;
            }
            node=node.next;
        }
        return head;
    }
}
