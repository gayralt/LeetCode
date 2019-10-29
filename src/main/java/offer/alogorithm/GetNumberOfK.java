package main.java.offer.alogorithm;

/**
 *统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public int getNumberOfK(int [] array , int k) {
        if (array.length<=0)
        return 0;

        int count=0;
        for (int num:array) {
            if (num==k)
                count++;
        }
        return count;
    }
}
