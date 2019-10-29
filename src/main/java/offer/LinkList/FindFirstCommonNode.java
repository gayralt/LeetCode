package main.java.offer.LinkList;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    //遍历查找链表节点数量
    //然后快慢指针查找公共节点
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (null==pHead1||null==pHead2)
            return null;

        int head1=0;
        int head2=0;
        ListNode node1=pHead1;
        ListNode node2=pHead2;
        //计数
        while (node1!=null){
            head1++;
            node1=node1.next;
        }
        while (node2!=null){
            head2++;
            node2=node2.next;
        }
        //快慢节点赋值
        ListNode fast=head1>head2?pHead1:pHead2;
        ListNode low=head1>head2?pHead2:pHead1;
        //fast先走多余的节点
        for (int i = 0; i < Math.abs(head1-head2); i++) {
            fast=fast.next;
        }
        //查找公共节点
        while (null!=fast&&null!=low){
            if (fast==low)
                break;
            fast=fast.next;
            low=low.next;
        }
        return fast;
    }
    public ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)
            return null;

        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        //为null从对方开头节点开始，到公共节点的距离一样
        //if a & b have different len, then we will stop the loop after second iteration
        while( node1 != node2){
            //不为null则next，为null则为另一个结点，然后结点相等，退出
            node1 = (node1 == null)? pHead2 : node1.next;
            node2 = (node2 == null)? pHead1 : node2.next;
        }

        return node1;
    }
    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(4);

        ListNode node2=new ListNode(8);
        node2.next=new ListNode(9);
        node2.next.next=new ListNode(8);
        node2.next.next.next=node.next.next;

        FindFirstCommonNode node1=new FindFirstCommonNode();
        node1.findFirstCommonNode2(node,node2);
    }
}
