package main.java.offer.tree;

/**
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNextNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (null==pNode)
            return pNode;
        TreeLinkNode parent=null;
        //1. 找右子树的左子树
        if (null!=pNode.right) {
            TreeLinkNode right=pNode.right;
            while (right.left!=null)
                right=right.left;
            return right;
        }
        //2. 循环找父节点的左结点
        else if (null!=pNode.next){
            while (null!=pNode.next){
                parent=pNode.next;
                if (parent.left==pNode)
                    return parent;
                else
                    pNode=parent;
            }
        }
        //找不到
        return null;
    }

    public static void main(String[] args) {
        GetNextNode getNextNode=new GetNextNode();
        TreeLinkNode t1=new TreeLinkNode(1);
        TreeLinkNode t2=new TreeLinkNode(2);
        TreeLinkNode t3=new TreeLinkNode(3);
        TreeLinkNode t4=new TreeLinkNode(4);
        TreeLinkNode t5=new TreeLinkNode(5);
        TreeLinkNode t6=new TreeLinkNode(6);
        TreeLinkNode t7=new TreeLinkNode(7);
        TreeLinkNode t8=new TreeLinkNode(8);
        TreeLinkNode t9=new TreeLinkNode(9);
        t1.left=t2;
        t1.right=t3;
        t2.next=t1;
        t2.left=t4;
        t2.right=t5;
        t4.next=t2;
        t5.next=t2;
        t5.left=t8;
        t5.right=t9;
        t8.next=t5;
        t9.next=t5;
        t3.next=t1;

        TreeLinkNode parent=getNextNode.GetNext(t3);
        System.out.println(parent.val);
    }
}
