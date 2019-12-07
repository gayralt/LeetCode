package main.java.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> results=new LinkedList<>();
        parenthesis(n-1,n,results,"(");
        return results;
    }
    private void parenthesis(int n,int m,List<String> results,String result){
        if (n<0||m<0)
            return;
        if (m>n&&n>0){
            parenthesis(n-1,m,results,result+"(");
            parenthesis(n,m-1,results,result+")");
        }else if (n>0){
            parenthesis(n-1,m,results,result+"(");
        }else if (m>0){
            parenthesis(n,m-1,results,result+")");
        }else {
            results.add(result);
        }
    }
    //简洁的回溯法
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis=new GenerateParenthesis();
        generateParenthesis.generateParenthesis2(3);
    }
}
