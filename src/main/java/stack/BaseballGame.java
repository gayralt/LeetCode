package main.java.stack;

import java.util.Stack;

/**
 *Given a list of strings, each string can be one of the 4 following types:
 *
 * Integer (one round's score): Directly represents the number of points you get in this round.
 * "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
 * "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
 * "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
 * Each round's operation is permanent and could have an impact on the round before and the round after.
 *
 * You need to return the sum of the points you could get in all the rounds.
 *
 *
 *
 *
 * 整数（一轮的分数）：直接表示你在这轮中得到的分数。
 *
 * “+”（一轮得分）：表示您在这轮中获得的分数是最后两个有效轮得分的总和。
 *
 * “D”（一轮得分）：表示您在本轮中获得的分数是最后一轮有效分数的双倍数据。
 *
 * “C”（一个操作，不是一个回合的分数）：表示你得到的最后一个有效回合的分数无效，应该删除。
 *
 *
 * 根据对应的操作，对栈进行操作
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack=new Stack<>();
        Integer count;
        Integer count2;
        Integer sum=0;
        for (int i=0;i<ops.length;i++){
            if (ops[i].equals("C")){
                count=stack.pop();
                sum-=count;
            }else if (ops[i].equals("D")){
                count=stack.peek()*2;
                stack.push(count);
                sum+=count;
            }else if (ops[i].equals("+")){
                count=stack.pop();
                count2=stack.peek();
                stack.push(count);
                count+=count2;
                sum+=count;
                stack.push(count);
            }else {
                count=Integer.parseInt(ops[i]);
                stack.push(count);
                sum+=count;
            }
        }
        return sum;
    }
}
