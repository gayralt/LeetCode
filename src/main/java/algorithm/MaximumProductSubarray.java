package main.java.algorithm;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * <p>
 * 最大乘积子序列
 */
class DPNode {
    public int max;
    public int min;

    public DPNode() {
    }

    public DPNode(int max, int min) {
        this.max = max;
        this.min = min;
    }
}

public class MaximumProductSubarray {
    /**
     * 动态规划，记录每个数访问当前nums的值时可以得出的最大值与最小值(上一个数的最大值/最小值*当前数与当前数的比较)
     * 最后进行比较，返回结果
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        DPNode[] nodes = new DPNode[nums.length];
        int result;
        nodes[0] = new DPNode(nums[0], nums[0]);
        result = nums[0];
        int max;
        int min;
        for (int i = 1; i < nums.length; i++) {
            //得出最大值
            max = (nodes[i - 1].max * nums[i] > nums[i] ? (nodes[i - 1].max * nums[i] > nodes[i - 1].min * nums[i] ? nodes[i - 1].max * nums[i] : nodes[i - 1].min * nums[i]) : (nums[i] > nodes[i - 1].min * nums[i] ? nums[i] : nodes[i - 1].min * nums[i]));
            //得出最小值
            min = (nodes[i - 1].max * nums[i] < nums[i] ? (nodes[i - 1].max * nums[i] < nodes[i - 1].min * nums[i] ? nodes[i - 1].max * nums[i] : nodes[i - 1].min * nums[i]) : (nums[i] < nodes[i - 1].min * nums[i] ? nums[i] : nodes[i - 1].min * nums[i]));
            nodes[i] = new DPNode(max, min);
            result = (nodes[i].max > result ? nodes[i].max : (nodes[i].min > result ? nodes[i].min : result));
        }
        return result;
    }
}
