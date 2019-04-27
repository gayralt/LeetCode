package main.java.DynamicProgramming;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * 爬楼梯的次数
 */
public class ClimbingStairs {
    //斐波那契数列
    public int climbStairs(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        Integer integer[] = new Integer[n];
        integer[0]=1;
        integer[1]=2;
        for (int i=2;i<n;i++){
            integer[i]=integer[i-1]+integer[i-2];
        }
        return integer[n-1];
    }
}
