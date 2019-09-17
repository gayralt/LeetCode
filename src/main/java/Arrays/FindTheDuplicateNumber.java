package main.java.Arrays;

/**
 * 剑指offer题目二
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 * 找相同数字，数组数量n+1 范围1~n，必定有一个或一个以上重复
 */
public class FindTheDuplicateNumber {
    //T(n)则用hashSet S（n） 可看剑指offer那里
    //S(1) T(n*logn)
    public int findDuplicate(int[] nums) {
        if (!valid(nums))
            return 0;
        int start=1;
        int end=nums.length-1;
        int middle,count;
        while (start<=end){
            //求中间数
            middle=((end-start)>>1)+start;
            //计数区域范围有多少个数
            count=countNumber(start,middle,nums);
            if (end==start){
                if (count>1)
                    return start;
                else
                    break;
            }
            //二分查找范围
            if (count>(middle-start+1))
                end=middle;
            else
                start=middle+1;
        }
        return 0;
    }
    //计数
    private int countNumber(int start,int end,int []nums){
        int count=0;
        for (int i = 0; i <nums.length; i++) {
            if (nums[i]>=start&&nums[i]<=end)
                count++;
        }
        return count;
    }
    //验证
    private boolean valid(int numbers[]) {
        if (null == numbers || numbers.length <= 1)
            return false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers.length - 1 || numbers[i] < 1)
                return false;
        }
        return true;
    }
    //https://www.cnblogs.com/hiddenfox/p/3408931.html
    //变成找有环链表，第一个环节点问题
    static int findDuplicate3(int[] nums)
    {
        if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }

    public static void main(String[] args) {
        int i=findDuplicate3(new int[]{1,2,3,4,5,6,3});
    }
}
