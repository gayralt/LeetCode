package main.java.LinkList;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        //判空
        if(null==head||null==head.next)
            return head;
        //快慢指针获取中间节点
        ListNode fast=head.next;
        ListNode lower=head;
        while (null!=fast&&fast.next!=null){
            fast=fast.next.next;
            lower=lower.next;
        }
        //获取中间节点
        ListNode mid=lower.next;
        lower.next=null;
        //左右节点递归
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        //新节点
        ListNode newHead=new ListNode(0);
        ListNode res=newHead;
        while (left!=null&&right!=null){
            if (left.val>right.val){
                newHead.next=right;
                right=right.next;
            }else {
                newHead.next=left;
                left=left.next;
            }
            newHead=newHead.next;
        }
        //剩余链表处理
        newHead.next=(left!=null)?left:right;
        return res.next;
    }

    public static void main(String[] args) {
        SortList sortList=new SortList();
        ListNode node1=new ListNode(4);
        node1.next=new ListNode(2);
        node1.next.next=new ListNode(1);
        node1.next.next.next=new ListNode(3);
        ListNode res=sortList.sortList(node1);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
