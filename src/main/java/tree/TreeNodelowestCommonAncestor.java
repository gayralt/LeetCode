package main.java.tree;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * 找两个节点的最近公共根节点
 */
public class TreeNodelowestCommonAncestor {
    /**
     * 递归，找到左或右则返回该节点
     * 递归返回，如果都不为空则为最小公共节点
     * 每个节点只遍历一次
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //当前根节点为空，或找到左或右节点则返回
        if (null == root || root == p || root == q) return root;
        //向左子树搜索
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //向右子树搜索
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果左为空，返回右，如果左不为空，右为空则返回左，右不为空则返回当前节点
        return left == null ? right : (right == null ? left : root);
    }
}
