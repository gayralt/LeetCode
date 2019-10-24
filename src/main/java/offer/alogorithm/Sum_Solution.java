package main.java.offer.alogorithm;

import static java.lang.Math.*;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum_Solution {
    public int Sum_Solution(int n) {
        return (n+(int) pow(n*1.0,2*1.0))>>1;
    }

    public static void main(String[] args) {
        Sum_Solution sum_solution=new Sum_Solution();
        System.out.println(sum_solution.Sum_Solution(10));
    }
}
