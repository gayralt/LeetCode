package main.java.sortAndSearch;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class findMin {
    public int findMin(int[] nums) {
//        int max=nums.length-1;
//        int min=0;
//        int mid;
//        while (min<max){
//            mid=min+(max-min)/2;
//            if (nums[min]<nums[mid]){
//                min=mid;
//            }else {
//                max=mid;
//            }
//        }
//        if (min<nums.length-1&&min>0&&nums[min]<nums[min-1]&&nums[min]<nums[min+1])
//            return nums[min];
//        else if (nums[min+1]<nums[min]&&((min+1)<nums.length-1&&nums[min+1]<nums[min+2]))
//            return nums[min+1];
//        return nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //选择右边进行比较
            //因为可能有序
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        findMin findMin=new findMin();
        findMin.findMin(new int[]{2,1});
    }
}
