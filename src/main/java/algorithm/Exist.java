package main.java.algorithm;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        if (board.length<=0||word==null||word.length()<=0)
            return false;
        boolean result=false;
        boolean[][] check=new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result=search(board,i,j,word,0,check);
                if (result)
                    break;
            }
            if (result)
                break;
        }
        return result;
    }
    private boolean search(char[][] board,int i,int j,String word,int index,boolean[][] check){
        if (index==word.length())
            return true;
        if (i<0||i>=board.length||j<0||j>=board[0].length)
        return false;
        boolean judge=false;
        if (board[i][j]==word.charAt(index)&&!check[i][j]){
            //进入true
            check[i][j]=true;
            judge=search(board,i-1,j,word,index+1,check)||search(board,i+1,j,word,index+1,check)
                    ||search(board,i,j+1,word,index+1,check)||search(board,i,j-1,word,index+1,check);
            //出去false
            check[i][j]=false;
        }
        return judge;
    }

    public static void main(String[] args) {
        Exist exist=new Exist();
        exist.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}},
        "ABCESEEEFS");
    }
}
