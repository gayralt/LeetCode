package main.java.Arrays;

/**
 * cvte笔试:26进制加该题
 * <p>
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 * <p>
 * 注意:
 * 数组长度 n 满足以下条件:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 * <p>
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * 输出:
 * 18
 * <p>
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-largest-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SplitArray {
    //评论解法
    public int splitArray1(int[] nums, int m) {
        //划分之后子数组最大值，大于数组中最大的一个元素，小于数组的总和
        long l = 0;
        long r = 0;
        int n = nums.length;
        //r是数组总和，l是数组中最大的值
        for (int i = 0; i < n; i++) {
            r += nums[i];
            if (l < nums[i]) {
                l = nums[i];
            }
        }
        long ans = r;
        while (l <= r) {
            //求出中间值mid，计算子数组和不大于mid时，能划分出几个子数组
            long mid = (l + r) >> 1;
            long sum = 0;
            int cnt = 1;//划分的子数组个数,初始值为1是因为，下面只在分割处加了1，分割1次，数组长度为2，所以初始值为1
            for (int i = 0; i < n; i++) {
                if (sum + nums[i] > mid) {
                    cnt++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            if (cnt <= m) {//划分出来的子数组少于m个，说明mid值大了
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {//划分出来的子数组多于m个，说明mid值小了
                l = mid + 1;
            }
        }
        return (int) ans;
    }

    //二分法解决
    //子数组最大值一定大于单个最大的数并且小于数组和
    //求二者中的中间值，然后遍历数组查看该值能分成几组数组
    //组数小于等于m，说明该数大了
    //组数大于m，说明该数小了
    //直到l==r
    public int splitArray(int[] nums, int m) {
        long oneMax = 0;
        long sum = 0;
        long l;
        long r;
        long mid;
        int cut;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > oneMax)
                oneMax = nums[i];
            sum += nums[i];
        }
        l = oneMax;
        r = sum;
        while (l < r) {
            //获得中间值
            mid = (l + r) >> 1;
            //层数
            cut = 1;
            sum=0;
            for (int i = 0; i < nums.length; i++) {
                //大于中间值，说明层数+1
                //数组和起点变化
                //否则更新数组和
                if (sum + nums[i] > mid) {
                    cut++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            //层数小于m 大了 r=mid 保留mid 防止=m时错过答案
            //大于m则小了
            if (cut<=m){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return (int) l;
    }

    public static void main(String[] args) {
        SplitArray splitArray = new SplitArray();
        splitArray.splitArray(new int[]{7, 2, 5, 10, 8}, 2);
    }
}
