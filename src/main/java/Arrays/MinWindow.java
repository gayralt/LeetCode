package main.java.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class MinWindow {
    /**
     * https://leetcode-cn.com/problems/minimum-window-substring/solution/hua-dong-chuang-kou-by-powcai-2/
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> lookup = new HashMap<>();
        //初始化字典
        for (char c : s.toCharArray()) lookup.put(c, 0);
        //t中出现的+1
        for (char c : t.toCharArray()) {
            if (lookup.containsKey(c)) lookup.put(c, lookup.get(c) + 1);
            else return "";
        }
        int start = 0;
        int end = 0;
        int min_len = Integer.MAX_VALUE;
        int counter = t.length();
        String res = "";
        //滑动窗口
        while (end < s.length()) {
            char c1 = s.charAt(end);
            //是t需要的字符
            if (lookup.get(c1) > 0) counter--;
            //更新字典
            lookup.put(c1, lookup.get(c1) - 1);
            end++;
            //当前字符串已包含所有需要的字符
            while (counter == 0) {
                //更新最小值
                if (min_len > end - start) {
                    min_len = end - start;
                    res = s.substring(start, end);
                }
                //获取窗口第一个字符
                char c2 = s.charAt(start);
                //该情况仅为res字符串中仅有一个t需要的字符，且该字符为当前窗口开始的字符
                //该字符出窗口，t需要的字符就少了需要增大窗口找字符
                //防-1的情况即不是子串的字符
                if (lookup.get(c2) == 0) counter++;
                //更新字典
               lookup.put(c2, lookup.get(c2) + 1);
                //缩小窗口
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinWindow window=new MinWindow();
        window.minWindow("ADOBECODEBANC","ABC");
    }
}
