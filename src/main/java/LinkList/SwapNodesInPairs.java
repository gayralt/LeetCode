package main.java.LinkList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 */
public class SwapNodesInPairs {
    /**
     * 论坛递归做法
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

    public ListNode swapPairs(ListNode head) {
        //为空则返回
        if (null==head)
        return head;
        ListNode node=new ListNode(0);
        node.next=head;
        //记住头结点，因为头结点可能会变
        ListNode newHead=node;
        ListNode change;
        //下下个结点不为空才交换
        for (int i=0;null!=node.next&&null!=node.next.next;i++,node=node.next){
            //偶数次才交换
            if (i%2==0){
                //3结点交换过程
                change=node.next.next;
                node.next.next=change.next;
                change.next=node.next;
                node.next=change;
            }
        }
        return newHead.next;
    }
}
