package main.java.offer.alogorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 如果没有小朋友，请返回-1
 */
public class LastRemaining_Solution {
    //模拟环，遍历，去值
    public int LastRemaining_Solution(int n, int m) {
        if (n<1||m<1)
            return -1;
        int num=(m-1)%n;
        List<Integer> nums=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i);
        }
        while (nums.size()>1){
            nums.remove(num);
            num=(num+m-1)%(--n);
        }
        return nums.get(0);
    }

    public static void main(String[] args) {
        LastRemaining_Solution solution=new LastRemaining_Solution();
        System.out.println(solution.LastRemaining_Solution(6,7));
    }
}