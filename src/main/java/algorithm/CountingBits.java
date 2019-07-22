package main.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * Follow up:
 *
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 *
 * 算bit 有多少个1
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] results=new int[num+1];
        Integer result;
        for (int i=0;i<=num;i++){
            result=0;
            int count=i;
            while (count!=0){
                if ((count&1)==1){
                    ++result;
                }
                count=count>>>1;
            }
            results[i]=result;
        }
        return results;
    }
    public int[] countBits1(int num) {
        int[] results=new int[num+1];
        results[0]=0;
        for (int i=1;i<=num;i++){
            //得出去除最低位的数有多少个1
           results[i]=results[i&(i-1)]+1;
        }
        return results;
    }
}
