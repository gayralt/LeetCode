package main.java.sortAndSearch;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length<=0||matrix[0].length<=0)
        return false;
        int i=0;
        int j=matrix[0].length-1;
        while (i>=0&&i<matrix.length&&j>=0&&j<matrix[0].length){
            if (matrix[i][j]>target){
                j--;
            }else if (matrix[i][j]<target){
                i++;
            }else
                return true;
        }
        return false;
    }
}
