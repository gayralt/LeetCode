package main.java.offer.LinkList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReversePrintArrayList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        if (!valid(listNode,arrayList))
            return arrayList;
        //使用栈
        List<Integer> list=new LinkedList<>();
        while (null!=listNode){
            ((LinkedList<Integer>) list).push(listNode.val);
            listNode=listNode.next;
        }
        while (null!=((LinkedList<Integer>) list).peek()){
            arrayList.add(((LinkedList<Integer>) list).pop());
        }
        return arrayList;
    }
    //验证
    private boolean valid(ListNode listNode,ArrayList<Integer> arrayList){
        if (null==listNode)
            return false;
        else if (null==listNode.next){
            arrayList.add(listNode.val);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ReversePrintArrayList list=new ReversePrintArrayList();
        ListNode node=new ListNode(0);
        node.next=new ListNode(1);
        node.next.next=new ListNode(2);
        node.next.next.next=new ListNode(3);
        node.next.next.next.next=new ListNode(4);
        System.out.println(""+list.printListFromTailToHead(node));
    }
}
