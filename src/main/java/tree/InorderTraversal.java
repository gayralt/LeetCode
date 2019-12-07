package main.java.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<>();
        if (null==root)
            return result;
        LinkedList<TreeNode> stack=new LinkedList();
        TreeNode current=root;
        do {
            while (current!=null){
                stack.push(current);
                current=current.left;
            }
            current=stack.pop();
            result.add(current.val);
            current=current.right;
        }while (!stack.isEmpty()||current!=null);
        return result;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(5);
        node.left=new TreeNode(3);
        node.right=new TreeNode(7);
        node.left.left=new TreeNode(2);
        node.left.right=new TreeNode(4);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(8);
        InorderTraversal traversal=new InorderTraversal();
        traversal.inorderTraversal(node);
    }
}
