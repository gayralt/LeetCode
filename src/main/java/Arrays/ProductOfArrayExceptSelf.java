package main.java.Arrays;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class ProductOfArrayExceptSelf {
    //建立左到右以及右到左两个数组
    //非常数空间
    public int[] productExceptSelf(int[] nums) {
        if (null==nums||nums.length<=0)
        return new int[0];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];
        int ride = 1;
        for (int i = 0; i < nums.length; i++) {
            ride = nums[i] * ride;
            left[i] = ride;
        }
        ride = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ride = nums[i] * ride;
            right[i] = ride;
        }
        int rightNum;
        int leftNum;
        for (int i = 0; i < nums.length; i++) {
            leftNum=i-1<0?1:left[i-1];
            rightNum=i+1>=nums.length?1:right[i+1];
            result[i]=leftNum*rightNum;
        }
        return result;
    }
    //直接out当左右数组
    public int[] productExceptSelf1(int[] nums) {
        int left = 1;
        int right = 1;
        int len = nums.length;
        int[] output = new int[len];
        //当前数左边的乘积
        for(int i=0;i<len;i++){
            output[i] = left;
            //左乘积
            left *= nums[i];
        }
        //乘上当前数右边的乘积
        for(int j=len-1;j>=0;j--){
            output[j] *= right;
            //右乘积
            right *= nums[j];
        }
        return output;
    }
    public static void main(String[] args) {
        ProductOfArrayExceptSelf self=new ProductOfArrayExceptSelf();
        System.out.println(self.productExceptSelf1(new int[]{1,2,3,4}));
    }
}
