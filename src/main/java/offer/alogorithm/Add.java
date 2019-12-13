package main.java.offer.alogorithm;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {
    public static int Add(int num1,int num2) {
        int a = num1^num2;//获取非进位位
        int b = num1&num2;//获取进位位，需要左移一位
        int c = b<<1;//左移，获取实际值
        //为0则表示没有进位位，都是非进位位
        if(b!=0) {
            //递归调用，直到无进位为止
            int end = Add(a, c);
            a=end;
        }
        return a;
    }

    public static void main(String[] args) {
        Add(3,-2);
    }
}
