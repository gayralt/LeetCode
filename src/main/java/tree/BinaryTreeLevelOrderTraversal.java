package main.java.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * 层序遍历
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        List<Integer> result;
        Queue<TreeNode> nodes;
        List<List<Integer>> results = new LinkedList<>();
        //入队出队法实现广度优先搜索
        while (queue.size() != 0) {
            result=new LinkedList<>();
            nodes=new LinkedList<>();
            //出队
            while (queue.size()!=0){
                node=queue.poll();
                if (node!=null) {
                    result.add(node.val);
                    nodes.add(node);
                }
            }
            //入队
            while (nodes.size()>0){
                node=nodes.poll();
                queue.add(node.left);
                queue.add(node.right);
            }
            if (result.size() > 0)
                results.add(result);
        }
        return results;
    }
}
