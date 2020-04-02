package main.java.Arrays;

import java.util.LinkedList;
import java.util.Vector;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */
public class Calculate {
    //1.中缀转后缀
    //2.计算后缀表达式
    public int calculate(String s) {
        //无符号时处理
        if (judgeOnlyNum(s)) {
            String res="";
            for (Character c:s.toCharArray()) {
                if (c!=' ')
                    res+=c;
            }
            return Integer.valueOf(res);
        }
        return evalRPN(midToBack(s));
    }

    //中缀转后缀加一个判断是否有符号 没有直接输出
    private String[] midToBack(String s) {
        //符号栈
        LinkedList<Character> stack = new LinkedList<>();
        //结果
        String[] res = new String[s.length()];
        int index=0;
        String num="";
        Character c;
        for (int i = 0; i < s.length(); i++) {
            c=s.charAt(i);
            if (c=='+'||c=='-'){
                //弹出同级或者优先级大于的符号
                while (!stack.isEmpty()){
                    res[index++]=""+stack.pop();
                }
                stack.push(c);
            }else if (c=='*'||c=='/'){
                //弹出同级符号
                while (!stack.isEmpty()&&(stack.peek()=='*'||stack.peek()=='/')){
                    res[index++]=""+stack.pop();
                }
                stack.push(c);
            }else if (c>='0'&&c<='9'){
                num="";
                while (i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    num+=s.charAt(i);
                    i++;
                }
                res[index++]=""+num;
                i--;
            }
        }
        while (!stack.isEmpty()){
            res[index++]=""+stack.pop();
        }
        return res;
    }

    //后缀表达式计算
    private int evalRPN(String[] tokens) {
        LinkedList<Long> stack = new LinkedList<>();
        for (String token : tokens) {
            if (token==null)
                continue;
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                //前-后
                stack.push(-stack.pop() + stack.pop());
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                //前/后
                Long num1 = stack.pop();
                stack.push(stack.pop() / num1);
            } else {
                stack.push(Long.valueOf(token));
            }
        }
        return Math.toIntExact(stack.pop());
    }
    private boolean judgeOnlyNum(String s){
        boolean judge=true;
        for (Character c:s.toCharArray()) {
            if (c=='+'||c=='-'||c=='*'||c=='/'){
                judge=false;
                break;
            }
        }
        return judge;
    }
    public static void main(String[] args) {
        Calculate calculate=new Calculate();
        calculate.calculate("0-2147483647");
    }
}
