package main.java.math;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {
    //0到本身作二分
    public int mySqrt(int x) {
        long low = 0;
        long high = x / 2 + 1;
        long middle;
        while (low < high) {
            //取右中位数
            middle = low + (high - low+1) / 2;
            if (middle * middle < x) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return (int) low;
    }
    //牛顿法求解
    public int mySqrt1(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }

//    作者：liweiwei1419
//    链接：https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static void main(String[] args) {
        MySqrt sqrt = new MySqrt();
        sqrt.mySqrt(2147395599);
    }
}
