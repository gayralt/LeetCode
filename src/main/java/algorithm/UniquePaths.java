package main.java.algorithm;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m<=0||n<=0)
            return 0;
        int[][] map=new int[m][n];
        map[0][0]=1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i-1>=0)
                    map[i][j]+=map[i-1][j];
                if (j-1>=0)
                    map[i][j]+=map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
}
