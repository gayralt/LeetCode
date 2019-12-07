package main.java.Arrays;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 数学表达式如下:
 * <p>
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
public class IncreasingTriplet {
    /**
     * 找最小值和中间值
     * 当一个数小于最小值时，替换最小值，最小值始终为最小的值，因为该值小于中值，不影响判断
     * 当一个数大于最小值，小于中值时，替换中值
     * 大于中值，返回true
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        if (null == nums || nums.length < 3)
            return false;
        int min=Integer.MAX_VALUE;
        int mid=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (min>nums[i]){
                min=nums[i];
            }else if (mid>nums[i]&&nums[i]>min){
                mid=nums[i];
            }else if (nums[i]>mid){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTriplet triplet = new IncreasingTriplet();
        triplet.increasingTriplet(new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,-1,-1,-1,3});
    }
}
