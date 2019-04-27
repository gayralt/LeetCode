package main.java.LinkList;

/**
 * Reverse a singly linked list.
 * 使用前插法,总共用到两个指针
 */
public class ReverseLinkedList {
    /**
     * 论坛解法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        // is there something to reverse?
        if (head != null && head.next != null)
        {
            ListNode pivot = head;
            ListNode frontier = null;
            //结点不为null，且结点下一个不为null
            while (pivot != null && pivot.next != null) {
                //记住下一个结点，即要放入头结点的结点
                frontier = pivot.next;
                pivot.next = pivot.next.next;
                //头结点变更
                frontier.next = head;
                head = frontier;
            }
        }
        //返回结点
        return head;
    }
    public ListNode reverseList(ListNode head) {
        //判空
        if (head==null)
            return head;
         ListNode newHead=head;
         head=head.next;
         newHead.next=null;
         ListNode node;

         while(null!=head){
             node=head.next;
             head.next=newHead;
             //交换整理
             newHead=head;
             head=node;
         }

         return head;
    }
}
