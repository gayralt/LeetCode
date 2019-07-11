package main.java.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * 给定一个数n 生成括号的所有组合
 */
public class GenerateParentheses {
    //递归添加括号
    public List<String> generateParenthesis(int n) {
        List<String> res=new LinkedList<>();
        generate(n,n,"",res);
        return res;
    }
    public void generate(int left,int right,String par,List<String> result){
        if (left==0&&right==0){
            result.add(par);
            return;
        }
        if (left>0){
            generate(left-1,right,par+"(",result);
        }
        if (right>left){
            generate(left,right-1,par+")",result);
        }
    }
}
