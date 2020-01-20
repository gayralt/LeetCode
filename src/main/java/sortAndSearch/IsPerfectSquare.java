package main.java.sortAndSearch;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long max = (num + 1) / 2;
        long min = 1;
        long mid;
        while (min < max) {
            mid = min + (max - min) / 2;
            //小了
            if (mid * mid < num) {
                min = mid + 1;
            } else if (mid * mid == num) {
                return true;
            } else {
                max = mid - 1;
            }
        }
        return min * min == num;
    }

    public static void main(String[] args) {
        IsPerfectSquare square=new IsPerfectSquare();
        square.isPerfectSquare(808201);
    }
}
