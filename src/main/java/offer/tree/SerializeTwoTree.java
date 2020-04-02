package main.java.offer.tree;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，
 * 序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
public class SerializeTwoTree {
    int index=-1;
    //前序遍历序列化
    String Serialize(TreeNode root) {
        if (null==root)
            return "#";
        String left=Serialize(root.left);
        String right=Serialize(root.right);
        return root.val+","+left+","+right;
    }
    //使用index达到遍历的效果
    TreeNode Deserialize(String str) {
        index++;
        //用，作分割符
        String[] strr = str.split(",");
        TreeNode root=null;
        //不到末尾或者不为空则递归赋值
        if(index<strr.length&&!strr[index].equals("#")) {
            root = new TreeNode(Integer.valueOf(strr[index]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;
    }


    public static void main(String[] args) {
        SerializeTwoTree twoTree=new SerializeTwoTree();
        TreeNode node=new TreeNode(8);
        node.left=new TreeNode(8);
        node.right=new TreeNode(7);
        node.left.left=new TreeNode(9);
        node.left.right=new TreeNode(2);
        node.left.right.left=new TreeNode(4);
        node.left.right.right=new TreeNode(7);
        String serialize=twoTree.Serialize(node);
        System.out.println(serialize);
        TreeNode root=twoTree.Deserialize("8,6,10,5,7,9,11");
        System.out.println(root);
    }
}
