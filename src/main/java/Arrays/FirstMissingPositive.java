package main.java.Arrays;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class FirstMissingPositive {
    //按下标交换，然后顺序查找第一个与索引不同的数
    public int firstMissingPositive(int[] nums) {
        if (null==nums||nums.length<=0)
            return 1;
        int i;
        for (i = 0; i < nums.length; i++) {
            //交换直到对应索引位置的值正确
            while (nums[i] > 0 && (nums[i] - 1) < nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
        }
        for (i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1)
                break;
        }
        return i + 1;
    }

    private void swap(int[] nums, int swap1, int swap2) {
        int swap = nums[swap1];
        nums[swap1] = nums[swap2];
        nums[swap2] = swap;
    }

    public static void main(String[] args) {
        FirstMissingPositive positive = new FirstMissingPositive();
        positive.firstMissingPositive(new int[]{1,2,0});
    }
}
