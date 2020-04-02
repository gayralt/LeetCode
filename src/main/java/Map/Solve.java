package main.java.Map;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Solve {
    /**
     * 深度优先遍历
     * 如果为边直接修改，不是则遍历查看是否被围绕
     * 出错。。。
     * @param board
     */
    public void solve(char[][] board) {
        if (null == board || board.length <= 0 || board[0].length <= 0)
            return;
        boolean[][] judge = new boolean[board.length][board[0].length];
        boolean[][] judgeO = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //未O且未遍历过
                if (board[i][j]=='O'&&!judgeO[i][j])
                    judegAndChange(board, i, j, judge,judgeO);
            }
        }
    }

    private boolean judegAndChange(char[][] board, int i, int j, boolean[][] judge,boolean[][] judgeO) {
        //边界检查
        if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
            if (board[i][j] == 'O')
                return true;
            else
                return false;
        }
        //为x则返回
        if (board[i][j]=='X')
            return false;
        //为O继续
        //第一个为防止重复遍历
        //第二个为剪枝
        judge[i][j] = true;
        judgeO[i][j]=true;
        //遍历周围
        boolean isSolve = (!judge[i-1][j]&&judegAndChange(board, i - 1, j,judge,judgeO))||(!judge[i+1][j]&&judegAndChange(board,i+1,j,judge,judgeO))
                ||(!judge[i][j-1]&&judegAndChange(board,i,j-1,judge,judgeO))||(!judge[i][j+1]&&judegAndChange(board,i,j+1,judge,judgeO));
        if (!isSolve) {
            board[i][j] = 'X';
            return false;
        }
        //变为未遍历
        judge[i][j] = false;
        return true;
    }

    /**
     * 论坛解法
     * 深度优先把边界O及其相邻的O改为-
     * 然后把-改为O O改为X
     */
    int row,col;
    public void solve2(char[][] board) {
        if(board==null||board.length==0)
            return ;
        row=board.length;
        col=board[0].length;
        for(int i=0;i<row;i++){
            dfs(board,i,0);
            dfs(board,i,col-1);
        }
        for(int j=0;j<col;j++){
            dfs(board,0,j);
            dfs(board,row-1,j);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                if(board[i][j]=='-')
                    board[i][j]='O';
            }
        }
        return ;
    }
    public void dfs(char[][] board,int i,int j){
        if(i<0||j<0||i>=row||j>=col||board[i][j]!='O')
            return;
        board[i][j]='-';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
        return ;
    }


    public static void main(String[] args) {
        Solve solve=new Solve();
        solve.solve(new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}});
        System.out.println("12");
    }
}
