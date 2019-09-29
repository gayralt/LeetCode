package main.java.offer.alogorithm;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 斐波那契变形，不同的是 第一个数为1
 * 第二个数为2
 *
 */
public class RectCover {
    //O（n）法，可以推通项公式
    public int rectCover(int target) {
        if (target <= 0)
            return 0;
        if (target == 1 )
            return 1;
        if (target == 2 )
            return 2;

        int lastOne = 1;
        int lastTwo = 2;

        for (int i = 3; i <= target; i++) {
            if ((i & 1) == 1)
                lastOne = lastTwo + lastOne;
            else
                lastTwo = lastTwo + lastOne;
        }
        return lastTwo>lastOne?lastTwo:lastOne;
    }
}
