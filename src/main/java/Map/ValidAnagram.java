package main.java.Map;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * 1. 排序后比对
 * 2. map计数
 */
public class ValidAnagram {

    //计数法 不过使用数组计数
    public boolean isAnagram1(String s, String t) {
        int[] sCharCount = new int[128];
        int[] tCharCount = new int[128];

        for(char letter : s.toCharArray()) {
            sCharCount[letter]++;
        }
        for(char letter : t.toCharArray()) {
            tCharCount[letter]++;
        }

        return Arrays.equals(sCharCount, tCharCount);
    }

    //比较是否相等
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> maps = new HashMap<>();
        HashMap<Character, Integer> mapt = new HashMap<>();
        this.setMap(maps, s);
        this.setMap(mapt, t);
        return maps.equals(mapt);
    }

    //map计数
    public void setMap(HashMap<Character, Integer> map, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
    }
}
