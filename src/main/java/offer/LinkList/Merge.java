package main.java.offer.LinkList;

/**
 *输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (null==list1&&null!=list2)
            return list2;
        else if (null!=list1&&null==list2)
            return list1;
        else if (null==list1&&null==list2)
            return list1;

        ListNode newList=new ListNode(0);
        ListNode node=newList;
        //比大小
        while (null!=list1&&null!=list2){
            if (list1.val<list2.val){
                node.next=list1;
                list1=list1.next;
            }else {
                node.next=list2;
                list2=list2.next;
            }
            node=node.next;
        }
        //余下赋值
        while (null!=list1){
            node.next=list1;
            list1=list1.next;
            node=node.next;
        }
        //余下直接赋值
        while (null!=list2){
            node.next=list2;
            list2=list2.next;
            node=node.next;
        }
        return newList.next;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(3);
        node.next.next=new ListNode(10);
        node.next.next.next=new ListNode(20);

        ListNode node2=new ListNode(4);
        node2.next=new ListNode(5);
        node2.next.next=new ListNode(6);
        node2.next.next.next=new ListNode(7);
        Merge merge=new Merge();
        merge.Merge(node,node2);

    }
}
