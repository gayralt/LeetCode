package main.java.offer.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers_Solution {
    public ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {
        if (null==input||input.length<=0||k<=0||input.length<k)
            return new ArrayList<>();
        //建立大顶堆
        PriorityQueue<Integer> queue=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int number:input) {
            //数量小于k
            if (queue.size()<k){
                queue.offer(number);
            }else if (queue.peek()>number){
                //顶部大于，顶部出队，该数入队
                queue.poll();
                queue.offer(number);
            }
        }
        ArrayList<Integer> result=new ArrayList<>(queue);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        GetLeastNumbers_Solution solution=new GetLeastNumbers_Solution();
        solution.getLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4);
    }
}
