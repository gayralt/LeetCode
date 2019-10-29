package main.java.offer.tree;


/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {
    int index=0;
    //二叉搜索树，第k小中序遍历即可
    TreeNode kthNode(TreeNode pRoot, int k) {
        if (null==pRoot)
            return null;
        TreeNode left=kthNode(pRoot.left,k);
        if (++index==k)
            return pRoot;
        TreeNode right=kthNode(pRoot.right,k);
        return left==null?(right==null?null:right):left;
    }

    public static void main(String[] args) {
        KthNode kthNodenode=new KthNode();
        TreeNode node=new TreeNode(5);
        node.left=new TreeNode(3);
        node.right=new TreeNode(7);
        node.left.left=new TreeNode(2);
        node.left.right=new TreeNode(4);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(8);
        kthNodenode.kthNode(node,3);
    }
}
