package main.java.LinkList;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 判断回文串
 */
public class PalindromeLinkedList {
    /**
     * 初步想法：遍历到中间(即一个等于下一个)，分成两个链表，逆置其中一个链表
     * 然后对比两个链表
     * 需要考虑问题
     * 1. 为空
     * 2. 两个链表不一样长
     * 3. 找不到中间即不是回文链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        //为空或单个是回文串
        if (null == head||null==head.next)
            return true;

        ListNode fast=head;
        ListNode lower=head;
        ListNode node;
        ListNode changeNode;
        ListNode head1;
        //获得中间结点
        while (null!=fast&&null!=fast.next){
            lower=lower.next;
            fast=fast.next.next;
        }
        //反转另一半的链表
        node=lower;
        head1=lower;
        while(null!=node.next){
         changeNode=node.next;
         node.next=node.next.next;
         changeNode.next=head1;
         head1=changeNode;
        }
        //对比
        while (null!=head&&null!=head1){
            if (head.val!=head1.val){
                return false;
            }
            head=head.next;
            head1=head1.next;
        }
        return true;
    }
}
