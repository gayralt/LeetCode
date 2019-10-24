package main.java.offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 之字形打印树
 */
public class PrintZ {
    //改为使用栈进行BFS
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (null == pRoot)
            return new ArrayList<>();

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int current=1;
        //两个栈辅助，largest负责出栈，current入栈，largest为空则current变为largest
        LinkedList<TreeNode> stackLargets = new LinkedList<>();
        LinkedList<TreeNode> stackCurrent = new LinkedList<>();
        TreeNode node;
        stackLargets.push(pRoot);
        while (!stackLargets.isEmpty()||!stackCurrent.isEmpty()) {
            //换行
            if (stackLargets.isEmpty()) {
                stackLargets=stackCurrent;
                stackCurrent=new LinkedList<>();

                results.add(result);
                result=new ArrayList<>();
                current=1-current;
            }//入栈，奇数先左后右，偶数先右后左
            else {
                node = stackLargets.pop();
                if (current==1) {
                    if (node.left != null) {
                        stackCurrent.push(node.left);
                    }
                    if (node.right != null) {
                        stackCurrent.push(node.right);
                    }
                }else if (current==0){
                    if (node.right != null) {
                        stackCurrent.push(node.right);
                    }
                    if (node.left != null) {
                        stackCurrent.push(node.left);
                    }
                }
                result.add(node.val);
            }
        }
        //加入最后一层
        if (!result.isEmpty())
            results.add(result);
        return results;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);
        node.left.left.left=new TreeNode(8);
        node.left.left.right=new TreeNode(9);
        node.left.right.left=new TreeNode(10);
        node.left.right.right=new TreeNode(11);
        node.right.left.left=new TreeNode(12);
        node.right.left.right=new TreeNode(13);
        node.right.right.left=new TreeNode(14);
        node.right.right.right=new TreeNode(15);

        PrintZ printZ=new PrintZ();
        printZ.Print(node);
    }
}
