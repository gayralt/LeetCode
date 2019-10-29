package main.java.offer.tree;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
    public int treeDepth(TreeNode root) {
        if (null==root)
            return 0;
        //递归
        int left=treeDepth(root.left);
        int right=treeDepth(root.right);
        //返回最深处+1
        return left>right?left+1:right+1;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(8);
        node.left=new TreeNode(8);
        node.right=new TreeNode(7);
        node.left.left=new TreeNode(9);
        node.left.right=new TreeNode(2);
        node.left.right.left=new TreeNode(4);
        node.left.right.right=new TreeNode(7);

        TreeDepth depth=new TreeDepth();
        System.out.println(depth.treeDepth(node));
    }
}
