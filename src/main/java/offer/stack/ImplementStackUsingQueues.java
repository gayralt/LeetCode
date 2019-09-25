package main.java.offer.stack;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class ImplementStackUsingQueues {
    /**
     * 思路:只在出队时进行处理
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        //若s2为空时才 循环导s1的数据入s2，并出栈
        if (stack2.empty()) {
            while (!stack1.empty())
                stack2.push(stack1.pop());
        }
        if (stack2.empty())
            return -1;
        return stack2.pop();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues queues=new ImplementStackUsingQueues();
        queues.push(1);
        queues.push(2);
        queues.push(3);
        System.out.println(queues.pop()+","+queues.pop());
        queues.push(4);
        System.out.println(queues.pop());
        queues.push(5);
        System.out.println(queues.pop()+","+queues.pop());
    }
}
