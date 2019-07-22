package main.java.algorithm;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 *
 * 求是否是2的幂
 */
public class PowerOfTwo {
    //java int 型32位 位运算
    public boolean isPowerOfTwo(int n) {
        int sum=0;
        for (int i=0;n!=0&&i<=31;i++){
            if ((n&1)==1){
                //检查是否负数
                if (i==31)
                    return false;
                sum++;
            }
            n=n>>>1;
        }
        return sum==1?true:false;
    }
}
