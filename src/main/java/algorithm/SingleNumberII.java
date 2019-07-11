package main.java.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * 找只出现一次的数
 */
public class SingleNumberII {
    //map计数
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        Integer key=-1;
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()==1){
                key=entry.getKey();
            }
        }
        return key;
    }
    //排序法
    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; i = i+3) {
            if(nums[i] != nums[i+2]) return nums[i];
        }
        return nums[nums.length-1];
    }
}
