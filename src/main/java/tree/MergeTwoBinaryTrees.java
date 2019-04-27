package main.java.tree;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree.
 * The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node. Otherwise,
 * the NOT null node will be used as the node of new tree.
 */
public class MergeTwoBinaryTrees {
    /**
     * 递归合并两颗二叉树，合并到t1
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //判空
        if(null!=t1&&null!=t2){
            t1.val+=t2.val;
        }else if (null==t1||null==t2){
            return t1==null?t2:t1;
        }
        //递归调用
        mergeTrees(t1.left,t2.left);
        mergeTrees(t1.right,t2.right);
        //添加左结点
        if (t1.left==null&&t2.left!=null)
            t1.left=t2.left;
        //添加右结点
        if (t1.right==null&&t2.right!=null)
            t1.right=t2.right;
        return t1;
    }

    /**
     * 论坛做法
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return t2;
        else if(t2 == null)
            return t1;
        else {
            t1.val = t1.val + t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
    }
}
