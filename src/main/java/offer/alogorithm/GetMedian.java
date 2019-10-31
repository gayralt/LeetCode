package main.java.offer.alogorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class GetMedian {
    //大顶堆
    PriorityQueue<Integer> leftHeap=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    //小顶堆
    PriorityQueue<Integer> rightHeap=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });
    public void insert(Integer num) {
        //左堆，偶数插左堆，奇数插右堆，还需要比较数字与另外一堆的最小/最大值
        if (((leftHeap.size()+rightHeap.size())&1)==1){
            //num大于右堆的最小值
            if (rightHeap.size()!=0&&num>rightHeap.peek()){
                //插入右堆的顶部
                leftHeap.offer(rightHeap.poll());
                //新数插入右堆
                rightHeap.offer(num);
            }else {
                leftHeap.offer(num);
            }
        }else//右堆
            {
            //num小于左堆的最大值
            if (leftHeap.size()!=0&&num<leftHeap.peek()){
                rightHeap.offer(leftHeap.poll());
                leftHeap.offer(num);
            }else {
                rightHeap.offer(num);
            }
        }
    }

    public Double getMedian() {
        Double result=0.0;
        //看总数，总数奇数，结果为右堆第一个，偶数则是左堆与右堆的顶部相加除2
        if (((leftHeap.size()+rightHeap.size())&1)==1){
            result=1.0*rightHeap.peek();
        }else {
            result=1.0*(leftHeap.peek()+rightHeap.peek())/2;
        }
        return result;
    }

    public static void main(String[] args) {
        GetMedian median=new GetMedian();
        median.insert(3);
        median.insert(2);
        median.insert(4);
        System.out.println(median.getMedian());
        median.insert(1);
        System.out.println(median.getMedian());
        median.insert(8);
        System.out.println(median.getMedian());
        median.insert(7);
        System.out.println(median.getMedian());
    }
}
