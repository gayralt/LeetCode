package main.java.offer.arrays;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 从右上角或者左下角开始找
 */
public class TwoDimensionalArray {
    public boolean Find(int target, int[][] array) {
        if (!valid(array))
            return false;
        int column = array.length - 1;
        //第一次循环，按列找
        for (int i = column; i >= 0; i--) {
            if (array[i][0] == target)
                return true;
            if (array[i][0] < target) {
                column = i;
                if (findInRow(column, array, target))
                    return true;
            }
        }
        return false;
    }
    public boolean Find2(int target, int[][] array) {
        if (!valid(array))
            return false;
        int rows = array.length;
        int cols = array[0].length;
        // 右上
        int row = 0;   //注意
        int col = cols-1;    //注意
        while(row<rows && col>=0){    //注意
            if(array[row][col] < target){
                row++;        //注意
            }else if(array[row][col] > target){
                col--;      //注意
            }else{
                return true;
            }
        }
        return false;
    }
    private boolean valid(int[][] array) {
        if (null == array || array.length <= 0 || array[0].length<=0)
            return false;
        return true;
    }

    private boolean findInRow(int column, int[][] array, int target) {
        //第二次循环，按行找
        for (int i = 0; i < array[column].length; i++) {
            if (array[column][i] == target)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TwoDimensionalArray two = new TwoDimensionalArray();
        System.out.println(two.Find(1, new int[][]{{}}));
    }
}
