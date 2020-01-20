package main.java.match._177;

/**
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 *
 * 请你返回让 s 成为回文串的 最少操作次数 。
 *
 * 「回文串」是正读和反读都相同的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 * 示例 2：
 *
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 * 示例 3：
 *
 * 输入：s = "leetcode"
 * 输出：5
 * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
 * 示例 4：
 *
 * 输入：s = "g"
 * 输出：0
 * 示例 5：
 *
 * 输入：s = "no"
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 中所有字符都是小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinInsertions {
    //即是字符串长度-最长回文子串长度
    public int minInsertions(String s) {
        char[] a = s.toCharArray();
        int[] dp = new int[a.length + 1];
        int previous = 0; // 存放 dp[i-1][j-1]
        int swap = 0; // 用于交换dp[k]和previous
        int k = 1; // 避免循环中判断j>0

        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < a.length; j++) {
                swap = dp[k];
                if (a[i] == a[j]) {
                    dp[k] = previous + 1;
                } else {
                    dp[k] = Math.max(dp[k], dp[k - 1]);
                }
                previous = swap;
                k++;
            }
            previous = 0;
            k = 1;
        }

        return a.length - dp[a.length];
    }

    public static void main(String[] args) {
        MinInsertions insertions=new MinInsertions();
        insertions.minInsertions("mbadm");
    }
}
