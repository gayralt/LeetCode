package main.java.offer.alogorithm;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        //校验
        if (threshold <= 0 || rows <= 0 || cols <= 0)
            return 0;
        int count = 0;
        //标识数组
        boolean[] flag = new boolean[rows * cols];
        //起点为0，0
        count += this.moving(threshold, 0, rows, 0, cols, flag);
        return count;
    }

    private int moving(int k, int row, int rows, int col, int cols, boolean[] flag) {
        int count=0;
        if (row>=0&&row<rows&&col>=0&&col<cols&&!flag[row*cols+col]&&k>=(this.count(row)+this.count(col))){
            //通过校验
            flag[row*cols+col]=true;
            count=1+moving(k,row+1,rows,col,cols,flag)+moving(k,row,rows,col+1,cols,flag)+
                    moving(k,row-1,rows,col,cols,flag)+moving(k,row,rows,col-1,cols,flag);
        }
        return count;
    }
    private int count(int numbers){
        int count=0;
        while (numbers>0){
            count+=numbers%10;
            numbers/=10;
        }
        return count;
    }

    public static void main(String[] args) {
        MovingCount movingCount=new MovingCount();
        System.out.println(movingCount.movingCount(10,1,100));
    }
}
