package main.java.offer.LinkList;

/**
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Clone {
    //逐点复制，然后分离出来
    public RandomListNode clone(RandomListNode pHead) {
        //空节点或者单结点
        if (pHead == null)
            return pHead;

        RandomListNode node=pHead;
        //新增节点
        while (null!=node){
            RandomListNode newNode=new RandomListNode(node.label);
            RandomListNode next=node.next;
            node.next=newNode;
            newNode.next=next;
            //新节点后开始
            node=next;
        }
        node=pHead;
        //复制指针
        while (null!=node&&node.next!=null){
            if (null!=node.random)
            node.next.random=node.random.next;
            node=node.next.next;
        }
        node=pHead;
        RandomListNode newHead=pHead.next;
        //分离
//        while (null!=node&&null!=node.next){
//            node.next=node.next.next;
//            node=node.next;
//        }
        while(node != null) {
            RandomListNode cloneNode = node.next;
            //原链表和先链表分开
            node.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            node = node.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        RandomListNode node=new RandomListNode(1);
        node.next=new RandomListNode(2);
        node.next.next=new RandomListNode(3);
        node.next.next.next=new RandomListNode(4);
        node.next.next.next.next=new RandomListNode(5);
        node.random=node.next.next;//3
        node.next.random=node.next.next.next.next;//5
        //#
        node.next.next.next.random=node.next;//2
        //#

        Clone clone=new Clone();
        RandomListNode head=clone.clone(node);
    }
}
