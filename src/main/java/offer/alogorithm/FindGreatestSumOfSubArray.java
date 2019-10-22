package main.java.offer.alogorithm;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决
 * 。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class FindGreatestSumOfSubArray {
    public int findGreatestSumOfSubArray(int[] array) {
        if (null==array||array.length<=0)
            return 0;

        int sum=Integer.MIN_VALUE;
        int max=sum;
        for (int num:array) {
            //sum小于当前数字且小于0，重新开始
            if (sum<0&&sum<num)
                sum=num;
            else
                sum+=num;
            //最大值验证
            if (sum>max)
                max=sum;
        }

        return max;
    }

    public static void main(String[] args) {
        FindGreatestSumOfSubArray array=new FindGreatestSumOfSubArray();
        array.findGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2});
    }
}
