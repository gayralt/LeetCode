package main.java.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * 判断括号是否合法
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            //左括号入栈
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                list.push(s.charAt(i));
            } else {
                //右括号出栈，如果出栈前为空或者匹配全部括号后为空则不合法
                if (list.isEmpty())
                    return false;
                else {
                    if (s.charAt(i) == ')') {
                        if (list.peek() == '(')
                            list.pop();
                        else
                            return false;
                    } else if (s.charAt(i) == ']') {
                        if (list.peek() == '[')
                            list.pop();
                        else
                            return false;
                    } else if (s.charAt(i) == '}') {
                        if (list.peek() == '{')
                            list.pop();
                        else
                            return false;
                    }
                }
            }
        }
        //匹配完 看是否为空
        return list.isEmpty();
    }

    /**
     * 论坛解法
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        //左括号则右括号入栈
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            //右括号 判空或者判顶部元素
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

}
