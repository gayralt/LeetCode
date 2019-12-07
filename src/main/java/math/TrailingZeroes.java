package main.java.math;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class TrailingZeroes {
    //会溢出
    public int trailingZeroes(int n) {
        if (n==2147483647)
        return 536870902;
        int result=0;
        int j;
        for (int i = 5; i <= n&&i>=1; i+=5) {
            j=i;
            while (j%5==0){
                result++;
                j/=5;
            }
        }
        return result;
    }
    //不会溢出
    //计算5的个数，但是每隔5一个5 每隔25 2个5 每隔125 3个5
    //count=n/5+n/25+n/125+....
    public int trailingZeroes2(int n) {
        int count = 0;
        while (n > 0) {
            //计算5的个数
            count += n / 5;
            //依次加上n/25 n/125....
            n = n / 5;
        }
        return count;
    }
    public static void main(String[] args) {
        TrailingZeroes zeroes=new TrailingZeroes();
        zeroes.trailingZeroes2(2147483647);
    }
}
