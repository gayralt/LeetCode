package main.java.stack;

import java.util.Stack;

/**
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings,
 * and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 *
 * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B,
 * with A and B nonempty valid parentheses strings.
 *
 * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k,
 * where P_i are primitive valid parentheses strings.
 *
 * Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 */
public class RemoveOutermostParentheses {


    /**
     * 较快的解法
     * @param S
     * @return
     */
    public String removeOuterParentheses2(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            //左括号则++
            //>0说明不是外层，然后+1
            if (c == '(' && opened++ > 0) s.append(c);
            //右括号则--
            //>1则说明不是外层括号，然后-1
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }

    /**
     * 正常思路？
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {
        Stack<Character> stack=new Stack<>();
        Character c;
        String result="";
        for (int i=0;i<S.length();++i) {
            c = S.charAt(i);
            //为空则说明是第一个括号
            if (stack.isEmpty()&&c=='('){
                stack.push(c);
                continue;
            }
            //为1则说明是外层括号
            if (stack.size()==1&&c==')'){
                stack.pop();
                continue;
            }
            if (c=='('){
                stack.push(c);
            }
            if (c==')'){
                stack.pop();
            }
            //不是外层的则作为结果
            result+=c+"";
        }
        return result;
    }
}
