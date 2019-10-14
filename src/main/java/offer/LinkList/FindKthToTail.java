package main.java.offer.LinkList;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    //快慢指针法
    public ListNode findKthToTail(ListNode head, int k) {
        if (k <= 0 || null == head)
            return null;
        ListNode fast = head;
        ListNode low = head;
        int count;
        for (count = 0; count < k; count++) {
            if (fast == null)
                break;
            fast = fast.next;
        }
        if (count != k - 1)
            return null;
        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }
}
