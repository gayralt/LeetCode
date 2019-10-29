package main.java.offer.alogorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        Set<Integer> set=new HashSet<>();
        int numOne=Integer.MAX_VALUE;
        int numTwo=Integer.MAX_VALUE;
        //set辅助查找
        for (int num:array) {
            if (set.contains(sum-num)){
                if (numOne==Integer.MAX_VALUE){
                    numOne=sum-num;
                    numTwo=num;
                }else {
                    if ((sum-num)*num<numOne*numTwo){
                        numOne=sum-num;
                        numTwo=num;
                    }
                }
            }else {
                set.add(num);
            }
        }
        ArrayList<Integer> result=new ArrayList<>();
        if (numOne!=Integer.MAX_VALUE) {
            result.add(numOne);
            result.add(numTwo);
        }
        return result;
    }
}
