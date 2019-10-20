package main.java.offer.tree;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    //递归，target减少，为0则说明相等，list加入结果集
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null||target<0)
            return result;
        //添加该节点
        list.add(root.val);
        //目标值变化
        target=target-root.val;
        if (target==0&&root.left==null&&root.right==null) {
            result.add(new ArrayList<>(list));
        }
        //递归
        findPath(root.left,target);
        findPath(root.right,target);
        //该节点在路径中的遍历结束，删除该节点
        list.remove(list.size()-1);
        return result;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(8);
        node.left=new TreeNode(8);
        node.right=new TreeNode(7);
        node.left.left=new TreeNode(9);
        node.left.right=new TreeNode(2);
        node.right.left=new TreeNode(1);
        node.right.right=new TreeNode(7);
        node.right.left.left=new TreeNode(2);


        FindPath findPath=new FindPath();
        findPath.findPath(node,18);
    }
}
