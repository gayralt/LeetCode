package main.java.offer.tree;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

/**
 *   填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *提示：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class Connect {
    //每次从最左开始往右连
    public Node connect(Node root) {
        if (null==root)
            return root;
        Node pre=null;
        Node cur=root;
        while (cur!=null){
            while (pre!=null){
                //左右节点相连
                pre.left.next=pre.right;
                //两节点的子节点部分相连
                if (pre.next!=null){
                    pre.right.next=pre.next.left;
                }
                pre=pre.next;
            }
            //下一层
            pre=cur;
            cur=cur.left;
        }
        return root;
    }
}
