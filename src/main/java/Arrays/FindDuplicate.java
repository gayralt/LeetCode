package main.java.Arrays;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class FindDuplicate {
    //快慢指针法
    public int findDuplicate(int[] nums) {
        if (null==nums||nums.length<=1)
            return 0;
        int fast=0;
        int low=0;
        //快慢指针找相遇节点
        do {
            fast=nums[nums[fast]];
            low=nums[low];
        }while (fast!=low);
        //初始化low，找成环的第一个节点
        low=0;
        while (low!=fast){
            low=nums[low];
            fast=nums[fast];
        }
        return low;
    }

    public static void main(String[] args) {
        FindDuplicate duplicate=new FindDuplicate();
        duplicate.findDuplicate(new int[]{1,3,4,2,2});
    }
}
