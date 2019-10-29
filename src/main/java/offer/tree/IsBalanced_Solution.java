package main.java.offer.tree;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalanced_Solution {
    //左右深度差别不过1
    public boolean isBalanced_Solution(TreeNode root) {
        return treeDepth(root)!=-1;
    }
    private int treeDepth(TreeNode root) {
        if (null==root)
            return 0;
        //递归
        int left=treeDepth(root.left);
        //左右差别大于1，直接返回
        if (left==-1)return -1;
        int right=treeDepth(root.right);
        //左右差别大于1，直接返回
        if (right==-1)return -1;
        //返回最深处+1，若不是平衡二叉树，返回-1
        return Math.abs(left-right)>1?-1:1+Math.max(left,right);
    }
}
