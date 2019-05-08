package main.java.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //新建一个map
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            //如果map里面有值与当前值相加为target
            //则返回，否则加入map
            if (null!=map.get(target-nums[i])){
                return new int[]{ map.get(target-nums[i]),i};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }
}
