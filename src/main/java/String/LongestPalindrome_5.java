package main.java.String;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class LongestPalindrome_5 {
    //中心拓展法，从中心向外拓展(n^2)
    public String  LongestPalindrome_5(String s) {
        if (null==s||s.length()<=0)
            return "";
        int start,end;
        start=end=0;
        for (int i = 0; i < s.length(); i++) {
            //奇数长度的字符串
            int len1=outFromCenter(s,i,i);
            //偶数长度的字符串,中心为两个字符
            int len2=outFromCenter(s,i,i+1);
            //取最长
            int len=Math.max(len1,len2);
            //取开始和结束值
            if (len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        //取某一段
        return s.substring(start,end+1);
    }
    private int outFromCenter(String s,int start,int end){
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
                start--;
                end++;
        }
        //注意长度
        return end-start-1;
    }

    public static void main(String[] args) {
        LongestPalindrome_5 ofLongestSubstring_3=new LongestPalindrome_5();
        ofLongestSubstring_3.LongestPalindrome_5("babadada");
    }
}
