package main.java.Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 */
public class ImplementStackusingQueues {
    LinkedList<Integer> queue;
    /** Initialize your data structure here. */
    public ImplementStackusingQueues() {
        queue=new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    //在添加结点时用两个队列实现栈的顺序
    public void push(int x) {
        LinkedList<Integer> queueTwo=new LinkedList<>();
        while (!queue.isEmpty()){
            queueTwo.offer(queue.pollLast());
        }
        queueTwo.offer(x);
        while (!queueTwo.isEmpty()){
            queue.offer(queueTwo.pollLast());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * 论坛解法，把自己的头添加到尾部，实现逆置
 */
class MyStack
{
    Queue<Integer> queue;

    public MyStack()
    {
        this.queue=new LinkedList<Integer>();
    }

    // Push element x onto stack.
    public void push(int x)
    {
        queue.add(x);
        for(int i=0;i<queue.size()-1;i++)
        {
            queue.add(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop()
    {
        queue.poll();
    }

    // Get the top element.
    public int top()
    {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty()
    {
        return queue.isEmpty();
    }
}
