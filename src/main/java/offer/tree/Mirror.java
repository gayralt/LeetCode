package main.java.offer.tree;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class Mirror {
    //迭代，交换左右子树
    public void mirror(TreeNode root) {
        if (null==root)
            return;
        TreeNode change;
        //交换
        change=root.left;
        root.left=root.right;
        root.right=change;
        //递归调用
        mirror(root.left);
        mirror(root.right);
    }

}
