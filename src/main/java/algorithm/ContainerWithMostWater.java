package main.java.algorithm;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * 给定的n的非负整数A1，A2，...，AN，其中每个表示在坐标（I，Al）的点。
 * n个垂直线被绘制为使得线的两个端点i是在（I，AI）和（i，0）。
 * 找到两条线，其与x轴一起形成一个容器，使得容器包含最水。
 * 注意：您可能不倾斜的容器和n至少为2。
 */
public class ContainerWithMostWater {
    /**
     * 公式:max(min(i1,i2)*(ai2-ai1))
     * 使用双指针法，先确定最长的长，再找高
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            //因为短板效应，所以哪边短算哪边，算完后移位，长的一方保留，因为可能变成短板，等待到与短的相遇或自己变成短的一方再移位
            res = height[i] < height[j] ? Math.max(res, (j - i) * height[i++]): Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
    public static void main(String[] args) {
        ContainerWithMostWater c=new ContainerWithMostWater();
        System.out.println(c.maxArea(new int[]{2,3,4,5,18,17,6}));
    }
}
