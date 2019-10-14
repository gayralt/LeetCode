package main.java.offer.LinkList;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    //前插法
    public ListNode ReverseList(ListNode head) {
        if (null==head||null==head.next)
            return head;
        ListNode newHead=new ListNode(0);
        //新节点
        newHead.next=head;
        ListNode node=head.next;
        head.next=null;

        ListNode pre;
        //不为空
        while (null!=node){
            //记录
            pre=newHead.next;
            //插入
            newHead.next=node;
            //下移
            node=node.next;
            //前插
            newHead.next.next=pre;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(3);
        node.next.next.next.next=new ListNode(4);
        node.next.next.next.next.next=new ListNode(4);
        node.next.next.next.next.next.next=new ListNode(5);

        ReverseList list=new ReverseList();
        list.ReverseList(node);
    }
}
