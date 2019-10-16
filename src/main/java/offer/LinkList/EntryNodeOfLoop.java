package main.java.offer.LinkList;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {
    //快慢指针法，找相遇，在从起点出发相遇一次，涉及到数学论证
    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (null==pHead||null==pHead.next)
            return null;

        ListNode fast=pHead;
        ListNode low=pHead;
        //找相遇
        while (fast!=null&&fast.next!=null&&low!=null){
            fast=fast.next.next;
            low=low.next;
            if (fast==low)
                break;
        }
        fast=pHead;
        //再次找相遇
        while (fast!=null&&low!=null&&fast!=low){
            fast=fast.next;
            low=low.next;
            if (fast==low)
                break;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        node.next.next.next.next.next=node;

        EntryNodeOfLoop loop=new EntryNodeOfLoop();
        loop.entryNodeOfLoop(node);
    }
}
