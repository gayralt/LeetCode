package main.java.tree;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
 * return its depth = 3.
 *
 * 查找最大深度
 *
 */
public class MaximumDepthOfBinaryTree {
    //DFS
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return maxDepthStack(root,1);

    }
    public int maxDepthStack(TreeNode root,int level){
        int left=level;
        int right=level;
        if (root.left!=null)
            left=maxDepthStack(root.left,level+1);
        if (root.right!=null)
            right=maxDepthStack(root.right,level+1);
        return left>right?left:right;
    }
}
