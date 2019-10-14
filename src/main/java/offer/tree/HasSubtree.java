package main.java.offer.tree;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    //递归判断节点是否相等，如不等，左右节点递归
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if (null==root1||null==root2)
            return false;
        return subtree(root1,root2,root2);
    }
    private boolean subtree(TreeNode node1,TreeNode node2,TreeNode root2){
        if (node2==null)//树2遍历完
            return true;
        else if (node1==null)//树2还未完，树1节点已完
            return false;
        boolean result=false;
        //值是否相等，是否能够继续验证
        if (node1.val==node2.val){
            result=this.subtree(node1.left,node2.left,root2)&&this.subtree(node1.right,node2.right,root2);
        }//与原根节点一样，重新验证
        else if (node1.val==root2.val){
            result=this.subtree(node1.left,root2.left,root2)&&this.subtree(node1.right,root2.right,root2);
        }
        //验证左右子树
        if (result==false)
        result = this.subtree(node1.left, root2, root2) || this.subtree(node1.right, root2, root2);

        return result;
    }
    //剑指offer解
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if(root1.val == root2.val){
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1,root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left,root2);
            }

            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right,root2);
            }
        }
        //返回结果
        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {
            return false;
        }

        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }
    public static void main(String[] args) {
        TreeNode node=new TreeNode(8);
        node.left=new TreeNode(8);
        node.right=new TreeNode(7);
        node.left.left=new TreeNode(9);
        node.left.right=new TreeNode(2);
        node.left.right.left=new TreeNode(4);
        node.left.right.right=new TreeNode(7);

        TreeNode node2 =new TreeNode(8);
        node2.left=new TreeNode(9);
        node2.right=new TreeNode(2);

        HasSubtree subtree=new HasSubtree();
        boolean result=subtree.HasSubtree(node,node2);
    }
}
