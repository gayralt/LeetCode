package main.java.offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
    //层序遍历/广度优先遍历
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();

        if (root==null)
            return result;

        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while (!queue.isEmpty()){
            //出队并打印
            node=queue.poll();
            result.add(node.val);
            //入队
            if (null!=node.left)
            queue.offer(node.left);
            if (null!=node.right)
            queue.offer(node.right);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(8);
        node.left=new TreeNode(8);
        node.right=new TreeNode(7);
        node.left.left=new TreeNode(9);
        node.left.right=new TreeNode(2);
        node.left.right.left=new TreeNode(4);
        node.left.right.right=new TreeNode(7);

        PrintFromTopToBottom bottom=new PrintFromTopToBottom();
        bottom.printFromTopToBottom(node);
    }
}
