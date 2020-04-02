package main.java.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 * If it does not exist, output -1 for this number.
 *
 * 您将得到两个数组（不带重复项）nums1和nums2，其中nums1的元素是nums2的子集。
 * 在nums2的相应位置中查找nums1元素的所有下一个更大的数字。
 * 数字x在nums1中的下一个较大数字是在nums2中右边的第一个较大数字。
 * 如果它不存在，则为此数字输出-1。
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //做一个缓存map
        Map<Integer, Integer> save = new HashMap<>();
        //用栈判断
        Stack<Integer> stack=new Stack<>();
        int[] result=new int[nums1.length];
        for (int i=0;i<nums2.length;i++){
            //如果栈顶小于当前，则退栈，继续判断之前的数字是否小于当前数字(即最靠近的较大数字)。
            while (!stack.isEmpty()&&nums2[i]>stack.peek()){
                save.put(stack.pop(),nums2[i]);
            }
            //无则入栈
            stack.push(nums2[i]);
        }
        for (int i=0;i<nums1.length;i++){
            //有则返回，无则默认-1
            result[i]=save.getOrDefault(nums1[i],-1);
        }
        return result;
    }
}
