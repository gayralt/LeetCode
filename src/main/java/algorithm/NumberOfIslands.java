package main.java.algorithm;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class NumberOfIslands {
    /**
     * 染色法
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int number = 0;
        //遍历全部 判断是否为1 然后调用染色函数
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if ('1' == grid[i][j]) {
                    DFSColor(grid, i, j);
                    number++;
                }
            }
        }
        return number;
    }

    public void DFSColor(char[][] grid, int x, int y) {
        if ('1' == grid[x][y]) {
            grid[x][y] = '0';
            if (x - 1 >= 0)
                DFSColor(grid, x - 1, y);
            if (y + 1 < grid[x].length)
                DFSColor(grid, x, y + 1);
            if (x + 1 < grid.length)
                DFSColor(grid, x + 1, y);
            if (y - 1 >= 0)
                DFSColor(grid, x, y - 1);
        }
    }
}
