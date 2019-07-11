package main.java.algorithm;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 *
 * 求sqrt
 */
public class Sqrt {
    //调库
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }
    //二分法
    public int mySqrt1(int x) {
        if (x==0||x==1)return x;
        int right=x,left=1,res=(1+x)/2,mid;
        while (left<=right){
            mid=(left+right)/2;
            if (mid==x/mid){
                return mid;
            }else if (mid>x/mid){
                right=mid-1;
            }else {
                left=mid+1;
                res=mid;
            }
        }
        return res;
    }
    //牛顿迭代法
    public int mySqrt2(int x) {
        long res=x;
        while (res>x/res)
            res=(res+x/res)/2;
        return (int) res;
    }
}
