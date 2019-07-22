package main.java.algorithm;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * 三角形求最短路径
 */
public class Triangle {
    /**
     * 动态规划
     * DP[j]=triangle[i,j]+min(DP[j],DP[j+1])
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        //获取最底层的数组
        List<Integer> list=triangle.get(triangle.size()-1);
        //从倒数第二层开始
        for (int i=triangle.size()-2;i>0;i--){
            for (int j=0;j<triangle.get(i).size();j++){
                //自底向上，获取当前值与底层的最小值，每次最底层的赋值数量都会-1，到最后list.get(0)为其最终结果
                list.set(j,triangle.get(i).get(j)+(list.get(j)>list.get(j+1)?list.get(j+1):list.get(j)));
            }
        }
        return list.get(0);
    }
}
