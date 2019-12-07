package main.java.LinkList;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null==l1||null==l2)
            return l1==null?l1:l2;

        ListNode head=l1;
        ListNode pre=new ListNode(-1);
        pre.next=l1;
        //先相加，再检查进位
        while (l1!=null&&l2!=null){
            l1.val+=l2.val;
            l1=l1.next;
            l2=l2.next;
            pre=pre.next;
        }
        if (l2!=null){
            pre.next=l2;
        }
        ListNode newL1=head;
        while (newL1!=null){
            if (newL1.val>9){
                newL1.val%=10;
                if (newL1.next!=null){
                    newL1.next.val+=1;
                }else {
                    newL1.next=new ListNode(1);
                }
            }
            newL1=newL1.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(2);
        node.next=new ListNode(4);
        node.next.next=new ListNode(3);

        ListNode node1=new ListNode(4);
        node1.next=new ListNode(6);
        node1.next.next=new ListNode(7);
        AddTwoNumbers addTwoNumbers=new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(node,node1);
    }
}
