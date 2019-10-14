package main.java.offer.alogorithm;

import java.util.Date;

/**
 * 输出1到n位数字的最大值
 * 考察大数问题
 * 数字使用char数组
 */
public class PrintNumber {
    //10^n
    public void printNumber(int n) {
        if (n <= 0)
            return;
        char[] number=new char[n+1];
        number[n]='\0';
        for (int i = 0; i < 10; i++) {
            number[0]= (char) (i+'0');
            this.myPrint(number,n,0);
        }
    }
    private void myPrint(char[] number,int length,int index){
        if (index==(length-1)){
            System.out.println(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index+1]= (char) (i+'0');
            myPrint(number,length,index+1);
        }
    }

    public static void main(String[] args) {
        PrintNumber p=new PrintNumber();
        System.out.println(new Date());
        p.printNumber(10);
        System.out.println(new Date());
        System.out.println("end");
    }
}
