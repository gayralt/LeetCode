package main.java.heap;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums,
 * which contains initial elements from the stream. For each call to the method KthLargest.add,
 * return the element representing the kth largest element in the stream.
 *
 * Example:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 *
 */
public class KthLargestElementInAStream {
    //解法1：排序，每次都排序N*k*（log k）
    //解法2: 优先队列(即堆) 做一个容量为k的小顶堆 n*log2 k
    //解法2优化：自己实现一个小顶堆
    private PriorityQueue<Integer> queue;
    //定义大小k
    private Integer k;
    public KthLargestElementInAStream(int k, int[] nums) {
        queue=new PriorityQueue<Integer>(k);
        this.k=k;
        //建立堆
        for (Integer num:nums){
            add(num);
        }
    }

    public int add(int val) {
        //大小小于k 进堆
        if (queue.size()<k){
            queue.offer(val);
        }//大小大于k 与堆顶判断
        else if (queue.peek()<val){
            queue.poll();
            queue.offer(val);
        }
        //返回堆顶 即第k大的项
        return queue.peek();
    }
}
