package main.java.tree;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 * 找最小深度
 * 即层数最小的叶子节点
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        //全为空反应其为叶子节点 返回0
        if (root==null)
            return 0;
        //左子树
        int left=minDepth(root.left);
        //右子树
        int right=minDepth(root.right);
        //判断 有一方为0则返回不为0的值+1(层数+1) 不为0证明不是叶子节点 否则返回较小值+1
        return (left==0||right==0)?left+right+1:Math.min(left,right)+1;
    }
}
