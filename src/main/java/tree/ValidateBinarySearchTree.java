package main.java.tree;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * 判断二叉查找树
 */
public class ValidateBinarySearchTree {
    //解法一:中序遍历法
    private Integer parentNode;

    public boolean isValidBST(TreeNode root) {
        //为空直接返回
        if (null == root)
            return false;
        //左结点不为空，递归
        if (null != root.left && !isValidBST(root.left))
            return false;
        //父不为空且当前小于父则返回false
        if (parentNode != null && root.val < parentNode)
            return false;
        //给父节点赋值
        parentNode = root.val;
        //右结点不为空，递归
        if (null != root.right && !isValidBST(root.right))
            return false;
        return true;
    }

    //解法二:min,max比较法
    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        //min递归到第一个数，max为局部最大
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
