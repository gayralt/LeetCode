package main.java.offer.tree;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
    TreeNode node;
    TreeNode head;
    //右为next，左为pre,头节点left为null，尾节点right为null
    public TreeNode convert(TreeNode pRootOfTree) {
        if (null==pRootOfTree)
            return null;
        //递归改变指针指向
        midHandle(pRootOfTree);
        node.right=null;
//        //根节点时，左结点要为null
//        pRootOfTree.left=null;
        //前序指针改变
        TreeNode pre=head;
        TreeNode current=head.right;
        while (current!=null){
            //改变下一节点的前序节点
            current.left=pre;
            //节点下移
            pre=current;
            current=current.right;
        }
        head.left=null;
        return head;
    }
    private void midHandle(TreeNode pRootOfTree){
        if (null==pRootOfTree)
            return;

        //中序遍历处理节点
        midHandle(pRootOfTree.left);

        if (head==null) {
            head = pRootOfTree;
            node=head;
        }
        else {
            //next
            node.right = pRootOfTree;

            //节点移动
            node=node.right;
        }
        midHandle(pRootOfTree.right);
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(8);
        node.left=new TreeNode(8);
        node.left.left=new TreeNode(9);
        node.left.right=new TreeNode(2);


        Convert convert=new Convert();
        convert.convert(node);
    }
}
