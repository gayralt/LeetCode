package main.java.algorithm;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 求x的n次方
 */
public class pow {
    //暴力法O(n)
    public double myPow1(double x, int n) {
        double result = 1.0;
        int flag = n > 0 ? n : -n;
        //特殊情况
        if (n == -2147483648 && x != 1.0 && x != -1.0)
            return 0.0;
        else if (n == -2147483648 && x == 1.0)
            return 1.0;
        else if (x == -1.0)
            return (n % 2 == 1.0) ? -1.0 : 1.0;
        //普通情况
        for (int i = 0; i < flag; i++) {
            result = n > 0 ? (result * x) : (result * (1.0 / x));
            //应对n很大，x很小的情况
            if (result == 0.0 || x == 1.0)
                return result;
        }
        return result;
    }

    //调库O(1)
    public double myPow2(double x, int n) {
        return Math.pow(x, n);
    }

    //分治O(logN)
    public double myPow3(double x, int n) {
        if (n == 0)
            return 1.0;
        if (n < 0){
            //特殊情况
            //-2147483648*-1=-2147483648，补码问题，取反+1还是它本身
            if (n == -2147483648) {
                if (x == 1.0 || x == -1.0)
                    return 1.0;
                else
                    return 0.0;
            }
            return 1.0 / myPow3(x, -n);
        }
        if (n % 2 == 1)
            return x * myPow3(x, n - 1);
        return myPow3(x * x, n / 2);
    }
    //移位法 O(log1)
    public double myPow4(double x, int n) {
        double res=1;
        if(n<0){
            if (n == -2147483648) {
                if (x == 1.0 || x == -1.0)
                    return 1.0;
                else
                    return 0.0;
            }
            x=1/x;
            n=-n;
        }
        while(n>0){
            if((n&1)==1){
                res=res*x;
            }
            x*=x;
            n=n>>1;
        }
        return res;
    }
}
