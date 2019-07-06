package main.java.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 * 求众数
 * count>n/2时可以立刻将其作为众数
 */
public class MajorityElement {
    /**
     * 利用map计数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        Integer max=0;
        Integer key=-1;
        //计数
        for (Integer num:nums){
            if (map.containsKey(num)){
                map.replace(num, map.get(num) + 1);
            }else {
                map.put(num,1);
            }
        }
        //获取最大的value值
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()>max){
                max=entry.getValue();
                key=entry.getKey();
            }
        }
        return key;
    }

    /**
     * O(1)论坛解法
     * @param num
     * @return
     */
    public int majorityElement1(int[] num) {
        int major = num[0];
        int count = 1;
        for (int i = 1; i < num.length; i++) {
            //为0证明不是众数换下一个
            if (count == 0) {
                count++;
                major = num[i];
            } //相等则+1
            else if (major == num[i]) {
                count++;
            } //出现其他数则-1，抵消，看最后会不会剩下，会则说明是出现次数最多的
            else count--;
        }
        return major;
    }
}
