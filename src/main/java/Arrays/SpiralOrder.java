package main.java.Arrays;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralOrder {
    //先遍历外围在遍历内圈
    //外->内 起点i+1 j+1 长-2 宽-2
    public List<Integer> spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length <= 0 || matrix[0].length <= 0)
            return new LinkedList<>();
        int startI = 0;
        int startJ = 0;
        int length = matrix[0].length;
        int wide = matrix.length;
        List<Integer> result = new LinkedList<>();
        //长宽大于0时继续
        while (length > 0 && wide > 0) {
            //四个循环遍历
            for (int i = startJ; i < length + startJ; i++) {
                result.add(matrix[startI][i]);
            }
            for (int i = startI + 1; i < wide + startI; i++) {
                result.add(matrix[i][startJ+length - 1]);
            }
            for (int i = startJ + length - 2; i >= startJ && wide > 1; i--) {
                result.add(matrix[startI+wide - 1][i]);
            }
            for (int i = startI + wide - 2; i > startI  && length > 1; i--) {
                result.add(matrix[i][startJ]);
            }
            //更新起点
            startI += 1;
            startJ += 1;
            //更新长宽
            length -= 2;
            wide -= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralOrder order = new SpiralOrder();
        order.spiralOrder(new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}});
    }
}
