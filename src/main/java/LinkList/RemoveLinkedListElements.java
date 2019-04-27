package main.java.LinkList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        //判空
        if (null==head)
            return head;
        //判断头结点是否要删除
        while(null!=head&&val==head.val){
            head=head.next;
        }
        //此结点为不需要删除的结点
        ListNode node=head;
        //删除结点
        while(null!=node&&null!=node.next){
            if (val==node.next.val){
                node.next=node.next.next;
                //防止连续多个需要删除
                continue;
            }
            node=node.next;
        }
        return head;
    }
}
