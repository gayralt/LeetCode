package main.java.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 */

/**
 * 使用两个栈
 */
public class ImplementQueueUsingStacks {
    private LinkedList linkedListOne;
    private LinkedList linkedListTwo;

    /** Initialize your data structure here. */
    //QUEUE构造器
    public ImplementQueueUsingStacks() {
        linkedListOne=new LinkedList();
        linkedListTwo=new LinkedList();
    }

    /** Push element x to the back of queue. */
    public void push(Integer x) {
        while (null!=linkedListTwo.peek()){
            linkedListOne.push(linkedListTwo.pop());
        }
        linkedListOne.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public Integer pop() {
        while (null!=linkedListOne.peek()){
            linkedListTwo.push(linkedListOne.pop());
        }
        return (Integer) linkedListTwo.pop();
    }

    /** Get the front element. */
    public Integer peek() {
        while (null!=linkedListOne.peek()){
            linkedListTwo.push(linkedListOne.pop());
        }
        return (Integer) linkedListTwo.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (null==linkedListOne.peek())?(linkedListTwo.size()>0?false:true):(linkedListOne.size()>0?false:true);
    }
}

/**
 * 论坛解法：只在push中使用两个栈来使得栈保持队列入队的顺序
 */
class MyQueue {
    Stack<Integer> queue = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> temp = new Stack<Integer>();
        while (!queue.empty()) {
            temp.push(queue.pop());
        }
        queue.push(x);
        while (!temp.empty()) {
            queue.push(temp.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        queue.pop();
    }

    // Get the front element.
    public int peek() {
        return queue.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return queue.empty();
    }
}