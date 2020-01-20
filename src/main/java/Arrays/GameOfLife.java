package main.java.Arrays;

/**
 * 根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * 输出:
 * [
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]
 * ]
 * 进阶:
 * <p>
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 */
public class GameOfLife {
    //创建新数组，遍历检查周围8个统计活细胞数量
    //根据原数组对新数组进行修改
    //再根据新数组修改原数组
    public void gameOfLife(int[][] board) {
        if (null == board || board.length <= 0 || board[0].length <= 0)
            return;
        int[][] old = new int[board.length][board[0].length];
        //记录老数组
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                old[i][j] = board[i][j];
            }
        }
        //遍历数组判断
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //存活
                if (old[i][j]==1){
                    //小于2 死亡
                    if (countLife(old,i,j)<2)
                        board[i][j]=0;
                    //大于3 死亡
                    else if (countLife(old,i,j)>3)
                        board[i][j]=0;

                }else {
                    //死细胞周围有三个活 复活
                    if (countLife(old,i,j)==3)
                        board[i][j]=1;
                }
            }
        }
    }

    //统计数组周围存活细胞数量
    private int countLife(int[][] board, int i, int j) {
        int res = 0;
        boolean iReduce = false;
        boolean jReduce = false;
        boolean iAdd = false;
        boolean jAdd = false;
        if (i - 1 >= 0)
            iReduce = true;
        if (j - 1 >= 0)
            jReduce = true;
        if (j + 1 < board[i].length)
            jAdd = true;
        if (i + 1 < board.length)
            iAdd = true;
        if (iReduce&&jReduce){
            if (1==board[i-1][j-1])
                res++;
        }
        if (iReduce&&jAdd){
            if (1==board[i-1][j+1])
                res++;
        }
        if (iAdd&&jReduce){
            if (1==board[i+1][j-1])
                res++;
        }
        if (iAdd&&jAdd){
            if (1==board[i+1][j+1])
                res++;
        }
        if (iReduce){
            if (1==board[i-1][j])
                res++;
        }
        if (iAdd){
            if (1==board[i+1][j])
                res++;
        }
        if (jReduce){
            if (1==board[i][j-1])
                res++;
        }
        if (jAdd){
            if (1==board[i][j+1])
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        GameOfLife gameOfLife=new GameOfLife();
        gameOfLife.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}
