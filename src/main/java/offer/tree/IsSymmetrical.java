package main.java.offer.tree;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical {
    //修改遍历顺序，检验是否相同
    boolean isSymmetrical(TreeNode pRoot) {
        return this.isSymmetrical(pRoot,pRoot);
    }
    private boolean isSymmetrical(TreeNode node1,TreeNode node2){
        //遍历完
        if (node1==null&&node2==null)
            return true;
        //中间发现不同
        if (null==node1||null==node2)
            return false;
        if (node1.val!=node2.val)
            return false;
        //左对比右，右对比左，对称f
        return isSymmetrical(node1.left,node2.right)&&isSymmetrical(node1.right,node2.left);
    }
}
