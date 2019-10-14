package main.java.offer.alogorithm;

import java.util.Map;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    //返回为int 32位判断
    //注意负数右移补一
    public int NumberOf1(int n) {
        int count=0;
        for (int i = 0; i < 32; i++) {
            if (1==(1&n))
                count++;
            n=n>>1;
        }
        return count;
    }
    //未知位数可用，java中为32次
    public int NumberOf2(int n) {
        int count=0;
        int flag=1;
        while (flag!=0){
            if ((n&flag)!=0)
                count++;
            flag=flag<<1;
        }
        return count;
    }
    //-1后与自己相与，可以去掉最右边的1，看能做出几次这样的操作
    public int NumberOf3(int n) {
        int count=0;
        while (n!=0){
            ++count;
            //去掉最右边的1
            n=(n-1)&n;
        }
        return count;
    }
    public static void main(String[] args) {
        NumberOf1 n=new NumberOf1();
        System.out.println(n.NumberOf3(7));
    }
}
