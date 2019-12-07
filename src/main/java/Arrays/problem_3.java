package main.java.Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class problem_3 {
    //自解
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() <= 0)
            return 0;
        if (s.length() == 1)
            return 1;
        HashSet<Character> set = new HashSet<>();
        int count = Integer.MIN_VALUE;
        int index = 0;
        for (int i = index; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (count < set.size())
                    count = set.size();
                set = new HashSet<>();
                i = ++index;
                set.add(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        return count > set.size() ? count : set.size();
    }

    //滑动窗口
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                //删除，直到不重复
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    //优化滑动窗口

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                //重复，比较大小，跳过带有重复部分的窗口
                i = Math.max(map.get(s.charAt(j)), i);
            }
            //记录大小，i为起点，j为终点
            ans = Math.max(ans, j - i + 1);
            //记录索引的下一个值
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}
