package main.java.offer.string;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
    //也可以把字符串分为两部分，后面的部分移到前面
    public String leftRotateString(String str,int n) {
        if (str.length()<n||n<0)
            return "";
        String result="";
        //从n处开始访问，索引超过长度则从头开始访问
        for (int i = 0; i < str.length(); i++) {
            //取模访问
            result+=str.charAt(n%str.length());
            n++;
        }
        return result;
    }
    //三次倒置
    public String leftRotateString2(String str,int n) {
        if (str.length()<n||n<0)
            return "";
        char[] chars=str.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,str.length()-1);
        reverse(chars,0,str.length()-1);
        return String.valueOf(chars);
    }
    private void reverse(char[] str,int start,int end){
        char change;
        while (start<end){
            change=str[start];
            str[start++]=str[end];
            str[end--]=change;
        }
    }
    public static void main(String[] args) {
        LeftRotateString string=new LeftRotateString();
        string.leftRotateString2("abcXYZdef",3);
    }
}
