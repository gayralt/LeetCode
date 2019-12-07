package main.java.math;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例:
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class IsHappy {
    public boolean isHappy(int n) {
        int fast=n;
        int low=n;
        do {
            fast=getNums(fast);
            fast=getNums(fast);
            low=getNums(low);
        }while (fast!=low&&fast!=1&&low!=1);
        return fast==1||low==1;
    }
    private int getNums(int i){
        int num;
        int result=0;
        while (i>0){
            num=i%10;
            result+=num*num;
            i/=10;
        }
        return result;
    }
    public static void main(String[] args) {
        IsHappy isHappy=new IsHappy();
        isHappy.isHappy(7);
    }
}
