package main.java.LinkList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 * 编写一个程序来查找两个单独链表开始相交的节点。
 *
 * 先两次遍历算个数，看谁比较长，长的跳过长的结点，即
 * 缩短到和短的链表一样长，再开始找结点
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * 论坛解法，不需要知道两者长度的查值
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeBetter(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //不为null则next，为null则为另一个结点，然后结点相等，退出
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }



    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null==headA||null==headB)
            return null;
        int A=0;
        int B=0;
        ListNode head1=headA;
        ListNode head2=headB;
        ListNode longHead;
        ListNode shordHead;
        while (null!=head1){
            head1=head1.next;
            A++;
        }
        while (null!=head2){
            head2=head2.next;
            B++;
        }
        //等长情况
        if (A==B){
            while (null!=headA&&null!=headB){
                if (headA==headB)
                    return headA;
                headA=headA.next;
                headB=headB.next;
            }
            return null;
        }

        if (A>B){
            longHead=headA;
            shordHead=headB;
        }else {
            longHead=headB;
            shordHead=headA;
        }

        for (int i=0;i<Math.abs(A-B);i++){
            longHead=longHead.next;
        }
        while (null!=longHead&&null!=shordHead){
            if (longHead==shordHead){
                return longHead;
            }
            longHead=longHead.next;
            shordHead=shordHead.next;
        }
        return null;
    }
}

