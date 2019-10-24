package main.java.offer.alogorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        int n;
        String s="";
        ArrayList<Integer> list= new ArrayList<Integer>();
        n=numbers.length;
        for(int i=0;i<n;i++){
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>(){
            //比较值
            public int compare(Integer str1,Integer str2){
                //比较组合后的值
                String s1=str1+""+str2;
                String s2=str2+""+str1;
                //依次比较各个值，再比较长度
                return s1.compareTo(s2);
            }
        });

        for(int j:list){
            s+=j;
        }
        return s;
    }

    public static void main(String[] args) {
        PrintMinNumber printNumber=new PrintMinNumber();
        printNumber.PrintMinNumber(new int[]{3,32,321});
    }
}
