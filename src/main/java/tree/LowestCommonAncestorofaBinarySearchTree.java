package main.java.tree;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * Example 1:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * <p>
 * 找最近公共节点，二叉搜索树版本，可以比二叉树版更加简便
 */
public class LowestCommonAncestorofaBinarySearchTree {
    /**
     * 循环版
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (null != root) {
            //都小于，都在左子树
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }//都大于，都在右子树
            else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }//不大于不小于，就是该节点
            else {
                break;
            }
        }
        return root;
    }

    /**
     * 递归版
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //向左子树搜索
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        //向右子树搜索
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
