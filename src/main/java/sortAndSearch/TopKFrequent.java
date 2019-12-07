package main.java.sortAndSearch;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
class Times {
    public int num;
    public int times;

    public Times() {
    }

    public Times(int num, int times) {
        this.num = num;
        this.times = times;
    }
}

public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //map查次数
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        LinkedList<Times> list = new LinkedList<>();
        for (Integer i : map.keySet()) {
            list.add(new Times(i, map.get(i)));
        }
        //优先队列找top k
        PriorityQueue<Times> queue = new PriorityQueue<>(k, new Comparator<Times>() {
            @Override
            public int compare(Times o1, Times o2) {
                return o1.times - o2.times;
            }
        });
        for (Times t : list) {
            if (queue.size() < k) {
                queue.offer(t);
            } else if (t.times > queue.peek().times) {
                queue.poll();
                queue.offer(t);
            }
        }
        LinkedList<Integer> result=new LinkedList<>();
        for (Times t:queue) {
            result.add(t.num);
        }
        return result;
    }
    public List<Integer> topKFrequent2(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        //比较函数通过去map里面调用值来比较，比上面的解法减少创建对象步骤
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }

    public static void main(String[] args) {
        TopKFrequent frequent = new TopKFrequent();
        frequent.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
    }
}
