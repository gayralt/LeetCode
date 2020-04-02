package main.java.Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (null==nums||nums.length<=0||k<=0)
        return new int[0];
        List<WindowsNode> nodes = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //去掉小于当前输入数字
            while (!nodes.isEmpty() && (((LinkedList<WindowsNode>) nodes).peekLast().getValue() < nums[i])) {
                ((LinkedList<WindowsNode>) nodes).pollLast();
            }
            //加入当前数字
            ((LinkedList<WindowsNode>) nodes).offerLast(new WindowsNode(nums[i], i));
            //检测第一个数是否出窗口
            if (((LinkedList<WindowsNode>) nodes).peekFirst().getIndex() <= i - k)
                ((LinkedList<WindowsNode>) nodes).pollFirst();
            if (i >= k - 1)
                result[index++] = ((LinkedList<WindowsNode>) nodes).peekFirst().value;
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow window = new MaxSlidingWindow();
        window.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
    }
}

class WindowsNode {
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
