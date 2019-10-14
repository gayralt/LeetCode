package main.java.offer.LinkList;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead==null||pHead.next==null)
            return pHead;
        //改为同一链表查找,使用flag做标记
        ListNode newList=new ListNode(-1);
        newList.next=pHead;
        //前驱，当前，标记定义
        ListNode preNode=newList;
        ListNode currentNode=pHead;
        ListNode flag=null;
        //查找重复节点
        while (currentNode!=null){
            //flag重复 跳过一个点（连续重复情况）
            if (flag!=null&&currentNode.val==flag.val) {
                preNode.next = currentNode.next;
                currentNode=preNode.next;
            }//发生重复 跳两个点+flag标记(单次重复情况)
            else if (currentNode.next!=null&&currentNode.val==currentNode.next.val){
                flag=currentNode;
                preNode.next = currentNode.next.next;
                currentNode=preNode.next;
            } else{
                //不重复 左移
                preNode=currentNode;
                currentNode=currentNode.next;
            }
        }
        return newList.next;
    }

    /**
     * 另一种解法
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication2(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        // 自己构建辅助头结点
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
            if(cur.next != null && cur.next.val == cur.val){
                // 相同结点一直前进
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
//        ListNode head=new ListNode(0);
//        ListNode node=head;
//        ListNode nextNode;
//        for (int i = 0; i < 1; i++) {
//            nextNode=new ListNode(i);
//            node.next=nextNode;
//            node=node.next;
//        }
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(3);
        node.next.next.next.next=new ListNode(4);
        node.next.next.next.next.next=new ListNode(4);
        node.next.next.next.next.next.next=new ListNode(5);

        DeleteDuplication d=new DeleteDuplication();
        ListNode newList=d.deleteDuplication(node);
        while (null!=newList){
            System.out.print(newList.val);
            newList=newList.next;
        }
    }
}
