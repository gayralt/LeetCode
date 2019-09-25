package main.java.offer.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * leetcode也有
 */
public class ReConstructBinaryTree {
    //递归前序推移，函数传递为值传递，将其改为引用传递
    private int preStart=0;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //验证
        if (pre == null || in == null || pre.length <= 0 || in.length <= 0)
            return null;
        return creatChildTree(pre, in, pre.length, 0, in.length-1);
    }

    TreeNode creatChildTree(int[] pre, int[] in, int preEnd, int inStart, int inEnd) {
        //初始化根节点
        int rootValue = pre[preStart];
        TreeNode root = new TreeNode(rootValue);
        int inNode = Integer.MAX_VALUE;
        //检查是否一致,如果是则为最底层节点，直接返回
        if (inStart == inEnd)
            return root;

        //查找中序节点
        for (int i = inStart; i <= inEnd; i++) {
            if (rootValue == in[i]) {
                inNode = i;
                break;
            }
        }

        //递归查找左子树和右子树
        if (preEnd > (preStart+1) && (inNode - 1) >= inStart) {
            preStart++;
            root.left = creatChildTree(pre, in, preEnd, inStart, inNode - 1);
        }
        if (preEnd > (preStart+1) && (inNode + 1) <= inEnd) {
            preStart++;
            root.right = creatChildTree(pre, in, preEnd, inNode + 1, inEnd);
        }
        return root;
    }

    //不用成员变量的方法
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length) return null;
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode build(int [] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh){
        if(preLow>preHigh || inLow>inHigh) return null;
        TreeNode root = new TreeNode(preorder[preLow]);

        int inorderRoot = inLow;
        for(int i=inLow;i<=inHigh;i++){
            if(inorder[i]==root.val){ inorderRoot=i; break; }
        }

        int leftTreeLen = inorderRoot-inLow;

        root.left = build(preorder, preLow+1, preLow+leftTreeLen, inorder, inLow, inorderRoot-1);
        //中序数组偏移左子树长度，访问右子树节点
        root.right = build(preorder, preLow+leftTreeLen+1, preHigh, inorder, inorderRoot+1, preHigh);
        return root;
    }

    //缓存中序数组编号，快速得到位置
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }

    public static void main(String[] args) {
        ReConstructBinaryTree tree = new ReConstructBinaryTree();
        TreeNode node=tree.reConstructBinaryTree(new int[]{3,1,2,4},
                new int[]{1,2,3,4});
        System.out.println(node);
    }
}
