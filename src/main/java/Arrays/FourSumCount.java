package main.java.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

public class FourSumCount {
    //分两组hash
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || A.length == 0)
            return 0;
        int count = 0;
        int length=A.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (map.containsKey(A[i]+B[j]))
                    map.replace(A[i]+B[j],map.get(A[i]+B[j])+1);
                else
                    map.put(A[i]+B[j],1);
            }
        }
        int sum;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                //取反
                sum=-(C[i]+D[j]);
                //有取反后的数即相加为0
                if (map.containsKey(sum))
                    count+=map.get(sum);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FourSumCount fourSumCount = new FourSumCount();
        fourSumCount.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
    }
}
