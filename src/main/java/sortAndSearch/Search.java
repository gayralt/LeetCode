package main.java.sortAndSearch;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Search {
    //先二分找起点终点
    //再二分找值
    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0)
            return -1;
        int start = 0;
        int end = nums.length - 1;
        int middle = 0;
        //找起始值
        while (start < end - 1) {
            middle = start + (end - start) / 2;
            if (nums[middle] < nums[end]) {
                end = middle;
            } else {
                start = middle;
            }
        }
        if (nums[end] < nums[start]) {
            start = end;
        }
        end = start + nums.length - 1;
        //找中间值
        while (start < end) {
            middle = start + (end - start) / 2;
            if (nums[middle % nums.length] < target) {
                start = middle + 1;
            } else if (nums[middle % nums.length] > target) {
                end = middle - 1;
            } else
                return middle % nums.length;
        }
        if (nums[start % nums.length] == target)
            return start % nums.length;
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        search.search(new int[]{1, 3, 5,7}, 7);
    }
}
