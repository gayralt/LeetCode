package main.java.algorithm;

/**
 *You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 您将获得两个非空链表，表示两个非负整数。 数字以相反的顺序存储，每个节点包含一个数字。 添加两个数字并将其作为链接列表返回。
 *
 * 您可以假设这两个数字不包含任何前导零，除了数字0本身。
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       int carry=0;
       ListNode l3,head=new ListNode(0);
       l3=head;
       while (l1!=null||l2!=null||carry!=0){
           if (l1!=null){
               carry+=l1.val;
               l1=l1.next;
           }
           if (l2!=null){
               carry+=l2.val;
               l2=l2.next;
           }
           l3.next=new ListNode(carry%10);
           carry/=10;
           l3=l3.next;
       }
       return head.next;
    }
}
