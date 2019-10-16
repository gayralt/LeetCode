package main.java.offer.alogorithm;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    //判别继续的条件，行，列数>起始点坐标乘积
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (null == matrix || matrix.length <= 0 || matrix[0] == null || matrix[0].length <= 0)
            return null;

        int column = matrix[0].length;
        int row = matrix.length;
        int start = 0;
        ArrayList<Integer> result = new ArrayList<>();
        //继续打印的判别条件
        while (column > start * 2 && row > start * 2) {
            print(matrix, column, row, start, result);
            start++;
        }
        return result;
    }

    //要防止重复打印
    private void print(int[][] matrix, int column, int row, int start, ArrayList<Integer> result) {
        int endX = column - 1 - start;
        int endY = row - 1 - start;

        //左到右
        for (int i = start; i <= endX; i++) {
            result.add(matrix[start][i]);
        }
        //上到下(右),终止行大于起始行，防止只有一行
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                result.add(matrix[i][endX]);
            }
        }
        //右到左，防止只有一列
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                result.add(matrix[endY][i]);
            }
        }
        //下到上，防止非n*n矩阵，防止只有两行(没必要下到上，上到下，左右来回即可)
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start+1; i--) {
                result.add(matrix[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        PrintMatrix number=new PrintMatrix();
        number.printMatrix(new int[][]{{1},{2},{3},{4},{5}});
    }
}
