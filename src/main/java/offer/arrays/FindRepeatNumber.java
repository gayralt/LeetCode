package main.java.offer.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的"一个"，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        int count = 0;
        Set set = new HashSet();
        //验证给定的数组
        if (!valid(numbers, length))
            return false;
        for (int number : numbers) {
            if (set.contains(number) && count < 1) {
                duplication[count] = number;
                count++;
            } else {
                set.add(number);
            }
        }
        if (0 == count)
            return false;
        return true;
    }

    private boolean valid(int numbers[], int length) {
        if (null == numbers || numbers.length <= 1)
            return false;
        for (int i = 0; i < length; i++) {
            if (numbers[i] > length - 1 || numbers[i] < 0)
                return false;
        }
        return true;
    }

    //空间复杂度为1 时间复杂度为n解法
    public boolean duplicate1(int numbers[], int length, int[] duplication) {
        if (!valid(numbers, length))
            return false;
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        findRepeatNumber.duplicate(new int[]{1, 2, 2}, 3, new int[3]);
    }
}
