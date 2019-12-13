package main.java.math;

public class GetSum {
    public int getSum(int a, int b) {
        //获取非进位和
        int num1=a^b;
        //获取进位值
        int num2=a&b;
        //左移进位
        int num3=num2<<1;
        int result=0;
        if (num2!=0){
            result=getSum(num1,num3);
            num1=result;
        }
        return num1;
    }
}
