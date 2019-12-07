package main.java.math;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 */
public class TitleToNumber {
    //26进制
    public int titleToNumber(String s) {
        char c;
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            c = s.charAt(i);
            sum += (c - 'A' + 1) * Math.pow(26, (s.length()-1)-i);
        }
        return sum;
    }

    public static void main(String[] args) {
        TitleToNumber number = new TitleToNumber();
        number.titleToNumber("ZY");
    }
}
