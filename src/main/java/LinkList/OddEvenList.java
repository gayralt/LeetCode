package main.java.LinkList;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (null==head||null==head.next)
            return head;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=even;
        while (odd.next!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(2);
        node.next=new ListNode(1);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(5);
        node.next.next.next.next=new ListNode(6);
        node.next.next.next.next.next=new ListNode(4);
        node.next.next.next.next.next.next=new ListNode(7);
        OddEvenList list=new OddEvenList();
        list.oddEvenList(node);
    }
}
