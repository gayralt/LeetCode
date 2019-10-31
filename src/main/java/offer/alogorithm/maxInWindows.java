package main.java.offer.alogorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class maxInWindows {
    //双端队列，入队从队尾开始比较，去掉小的，并检测队头是否过期
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        List<WindowsNode> nodes=new LinkedList<>();
        ArrayList<Integer> result=new ArrayList<>();
        if (size<=0)
        return result;
        for (int i = 0; i < num.length; i++) {
            if (nodes.isEmpty()){
                ((LinkedList<WindowsNode>) nodes).offerFirst(new WindowsNode(num[i],i));
            }else {
                //去掉小于当前输入数字
                while (!nodes.isEmpty()&&(((LinkedList<WindowsNode>) nodes).peekLast().getValue()<num[i])){
                    ((LinkedList<WindowsNode>) nodes).pollLast();
                }
                //加入当前数字
                ((LinkedList<WindowsNode>) nodes).offerLast(new WindowsNode(num[i],i));
            }
            //检测第一个数是否出窗口
            if (((LinkedList<WindowsNode>) nodes).peekFirst().getIndex()<=i-size)
                ((LinkedList<WindowsNode>) nodes).pollFirst();
            if (i>=size-1)
            result.add(((LinkedList<WindowsNode>) nodes).peekFirst().getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        maxInWindows windows=new maxInWindows();
        ArrayList arrayList=windows.maxInWindows(new int[]{2,3,4,2,6,2,5,1},0);
        System.out.println(arrayList);
    }
}
class WindowsNode{
    int value;
    int index;

    public WindowsNode(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }
}