package main.java.offer.tree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    //末尾为根，小于为左，大于为右
    //若在右子树中检查出小于根的则false 否则为true
    //递归检查
    public boolean verifySquenceOfBST(int[] sequence) {
        if (null == sequence||sequence.length<=0)
            return false;
        if (sequence.length == 1)
            return true;
        return squenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean squenceOfBST(int[] sequence, int start, int end) {
        if (start >= end)
            return true;
        int root = sequence[end];
        int mid = start;
        //分开左右子树
        while (root > sequence[mid]) {
            mid++;
        }
        //检查右子树
        for (int i = mid; i < end; i++) {
            if (root > sequence[i])
                return false;
        }
        return squenceOfBST(sequence, start, mid - 1) && squenceOfBST(sequence, mid, end-1);
    }

    public static void main(String[] args) {
        VerifySquenceOfBST bst=new VerifySquenceOfBST();
        System.out.println(bst.verifySquenceOfBST(new int[]{5,7,6,9,11,10,8}));
    }
}
