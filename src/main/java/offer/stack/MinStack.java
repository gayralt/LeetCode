package main.java.offer.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
 * （时间复杂度应为O（1））。
 */
public class MinStack {

    Stack<Integer> stack=new Stack<>();
    Stack<Integer> min=new Stack<>();

    public void push(int node) {
        //对最小栈做处理,入最小的数字
        if (min.isEmpty()){
            min.push(node);
        }else {
            int minNumber=min.peek();
            if (node>minNumber)
                min.push(minNumber);
            else
                min.push(node);
        }

        stack.push(node);
    }

    public void pop() {
        min.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack stack=new MinStack();
        stack.push(1);
        System.out.print(stack.min());
        stack.push(4);
        System.out.print(stack.min());
        stack.push(0);
        System.out.print(stack.min());
        stack.pop();
        stack.push(5);
        System.out.print(stack.min());
    }

}
