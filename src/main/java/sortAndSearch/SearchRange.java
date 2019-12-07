package main.java.sortAndSearch;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchRange {
    //二分查找开始和结束值
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        //分别查找开始和结束
        result[0] = this.findStart(nums, target);
        result[1] = this.findEnd(nums, target);
        //只有一个数的情况下
        if (result[0] == -1 && result[1] != -1)
            result[0] = result[1];
        return result;
    }

    private int findStart(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int middle;
        while (start <= end) {
            middle = start + (end - start) / 2;
            if (nums[middle] < target) {
                start = middle + 1;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else if ((middle - 1 >= 0 && nums[middle - 1] < target) || middle == 0) {
                return middle;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    private int findEnd(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int middle;
        while (start <= end) {
            middle = start + (end - start) / 2;
            if (nums[middle] < target) {
                start = middle + 1;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else if ((middle + 1 < nums.length && nums[middle + 1] > target) || middle == nums.length - 1) {
                return middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRange range = new SearchRange();
        range.searchRange(new int[]{3, 3, 3}, 3);
    }
}
