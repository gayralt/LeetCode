package main.java.algorithm;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * 寻找最长的上升子序列
 */
public class LongestIncreasingSubsequence {
    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        //判空
        if (nums.length<=0)
            return 0;
        //初始化
        int mp[]=new int[nums.length];
        int result=1;
        int max;
        for (int i=0;i<nums.length;i++){
            //初始化
            max=0;
            //寻找之前小于该数的次数,+1
            for (int j=0;j<i;j++){
                if ((mp[j]>max)&&(nums[i]>nums[j]))
                    max=mp[j];
            }
            mp[i]=max+1;
            if (mp[i]>result)
                result=mp[i];
        }
        return result;
    }
    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            //二分查找tail位置
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            //插入tail
            tails[i] = num;
            //等于尾节点 结果+1
            if(res == j) res++;
        }
        return res;
    }
    public static void main(String[] args) {
        LongestIncreasingSubsequence subsequence=new LongestIncreasingSubsequence();
        subsequence.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }
}
