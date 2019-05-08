package main.java.algorithm;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 1. 暴力法 3重循环
 * 2. set 存储 2重循环
 * 3. sort find
 */
public class ThreeSum {
    /**
     * 排序然后两边往中间夹 再去重
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        //数组末尾
        final int numsTail = nums.length - 1;
        //当前位置之后的头和尾
        int head;
        int tail;
        int sum;
        //定义结果集
        List<List<Integer>> results = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();
        //剩下的数量少于三时结束
        for (int i = 0; i < numsTail - 1; i++) {
            head = i + 1;
            tail = numsTail;
            //判断头加尾加当前值是否为0
            while (head < tail) {
                sum = nums[i] + nums[head] + nums[tail];
                //为0 加入结果集
                if (sum == 0) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[head]);
                    result.add(nums[tail]);
                    resultSet.add(result);
                    //向中间靠拢
                    head++;
                    tail--;
                } else if (sum > 0) {
                    //数值大了，尾值向前
                    tail--;
                } else if (sum < 0) {
                    //数值小了 头值向后
                    head++;
                }
            }
        }
        //去重加入
        for (List<Integer> c : resultSet) {
            results.add(c);
        }
        return results;
    }
}
