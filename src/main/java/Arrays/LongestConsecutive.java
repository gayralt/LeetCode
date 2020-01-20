package main.java.Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LongestConsecutive {
    //hashset求解
    public int longestConsecutive(int[] nums) {
        if (null == nums || nums.length <= 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        int res=0;
        //set装入
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (Integer s : set) {
            //不存在当前数字-1 则将其作为起点获得长度
            if (!set.contains(s-1)){
                int currentNum=s;
                int currentStreak=1;
                //存在+1的数字则长度+1
                while (set.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                res=Math.max(res,currentStreak);
            }
        }
        return res;
    }

    /**
     * 参考 这里 ，虽然不容易直接想到，但还是有迹可循的。
     *
     * 本质上就是把连续的序列进行合并，思路就是考虑我们先解决了小问题，然后大问题怎么解决。
     *
     * 假如我们已经了有连续的序列，123 和 56，并且序列的边界保存了当前序列的长度。
     * 1  2  3
     * 3     3  <- 序列长度
     *
     * 5  6
     * 2  2  <- 序列长度
     *
     * 此时来了一个数字 4
     * 我们只需要考虑 4 - 1 = 3,以 3 结尾的序列的长度
     * 以及 4 + 1 = 5,以 5 开头的序列的长度
     * 所以当前就会得到一个包含 4 的，长度为 3 + 1 + 2 = 6 的序列
     * 1  2  3  4  5  6
     * 3     3     2  2   <- 序列长度
     *
     * 此时把两个边界的长度进行更新
     * 1  2  3  4  5  6
     * 6     3     2  6   <- 序列长度
     *
     * 此时如果又来了 7
     * 我们只需要考虑 7 - 1 = 6,以 6 结尾的序列的长度
     * 以及 7 + 1 = 8,以 8 开头的序列的长度，但是不存在以 8 开头的序列，所以这个长度是 0
     * 所以当前就会得到一个包含 7 的，长度为 6 + 1 + 0 = 7 的序列
     * 1  2  3  4  5  6  7
     * 6     3     2  6     <- 序列长度
     *
     * 此时把两个边界的长度进行更新
     * 1  2  3  4  5  6 7
     * 7     3     2  6 7  <- 序列长度
     * 实现的话，我们可以用一个 HashMap ，存储以当前 key 为边界的连续序列的长度。可以再结合代码理解一下。
     *
     * 作者：windliang
     * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //已经考虑过的数字就跳过，必须跳过，不然会出错
            //比如 [1 2 1]
            //最后的 1 如果不跳过，因为之前的 2 的最长长度已经更新成 2 了，所以会出错
            if(map.containsKey(num)) {
                continue;
            }
            //找到以左边数字结尾的最长序列，默认为 0
            int left = map.getOrDefault(num - 1, 0);
            //找到以右边数开头的最长序列，默认为 0
            int right = map.getOrDefault(num + 1, 0);
            int sum = left + 1 + right;
            max = Math.max(max, sum);

            //将当前数字放到 map 中，防止重复考虑数字，value 可以随便给一个值
            map.put(num, -1);
            //更新左边界长度
            map.put(num - left, sum);
            //更新右边界长度
            map.put(num + right, sum);
        }
        return max;
    }


    public static void main(String[] args) {
        LongestConsecutive consecutive=new LongestConsecutive();
        consecutive.longestConsecutive(new int[]{100,4,200,1,3,2});
    }
}
