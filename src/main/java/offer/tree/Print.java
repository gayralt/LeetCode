package main.java.offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Print {
    //节点入队时，记录每一层的节点数，根据节点数打印完该层节点后换行
    ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        if (null == pRoot)
            return new ArrayList<>();
        //记录
        int largest = 1;
        int current = 0;
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            //换行
            if (largest == 0) {
                largest=current;
                current=0;
                results.add(result);
                result=new ArrayList<>();
            }//入队
            else if (largest > 0) {
                node = queue.poll();
                if (node.left!=null) {
                    queue.offer(node.left);
                    current++;
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                    current++;
                }
                result.add(node.val);
                largest--;
            }
        }
        //加入最后一层
        if (!result.isEmpty())
        results.add(result);
        return results;
    }
    public static void main(String[] args) {
        TreeNode node=new TreeNode(8);
        node.left=new TreeNode(8);
        node.right=new TreeNode(7);
        node.left.left=new TreeNode(9);
        node.left.right=new TreeNode(2);
        node.left.right.left=new TreeNode(4);
        node.left.right.right=new TreeNode(7);

        Print print=new Print();
        print.print(node);
    }
}
