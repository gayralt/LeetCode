package main.java.Queue;

import java.util.LinkedList;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * 滑动窗口最大值
 * <p>
 * 1. 大顶堆
 * <p>
 * 2. 双端队列 o(n)
 */

/**
 * 双端队列
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //记录下标
        LinkedList<Integer> list = new LinkedList<Integer>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //超过区域则出队
            if (list.peekFirst() != null && list.peekFirst() == i - k)
                list.pollFirst();
            //前面的值比后面的小则出队
            while (list.peekLast() != null && nums[list.peekLast()] < nums[i]) {
                list.pollLast();
            }
            //加入下标
            list.offer(i);
            //最左为最大
            if (i >= k - 1)
                result[i - k + 1] = nums[list.peekFirst()];
        }
        //若长度不足k
        if (nums.length < k || nums.length == 0)
            return (list.peek() == null) ? new int[0] : new int[]{nums[list.peekFirst()]};
        return result;
    }

    /**
     * 论坛解法 在双端队列法的基础上 把队列压缩为一个最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int max = nums[0];

        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i ++) {
            if (i != 0 && nums[i + k - 1] > max) {
                max = nums[i + k - 1];
                //System.out.println(max);
            } else if (i == 0 || nums[i - 1] == max) {
                max = nums[i];
                for (int j = i + 1; j < k + i; j ++) {
                    if(nums[j] > max) {
                        max = nums[j];
                    }
                }
                //System.out.println(max);
            }

            res[i] = max;
        }
        return res;
    }
}

