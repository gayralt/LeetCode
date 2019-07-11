package main.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 *
 * N 皇后问题，N个皇后不能互相攻击
 */
public class N_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(n<1)
            return result;
        solve(result, new ArrayList<String>(), n, 0,new boolean[n], new boolean[2*n], new boolean[2*n]);
        return result;
    }
    public void solve(List<List<String>> result, List<String> cur,
                      int n, int rowCur, boolean[] col, boolean[] diag1,
                      boolean[] diag2){
        if(rowCur==n){
            result.add(new ArrayList<String>(cur));
            return;
        }
        for(int j = 0; j<n; j++){
            int d1=rowCur+j;
            int d2=j-rowCur+n-1;
            if(!col[j] && !diag1[d1] && !diag2[d2]){
                col[j]=true;
                diag1[d1]=true;
                diag2[d2]=true;
                char[] helpChars=new char[n];
                Arrays.fill(helpChars,'.');
                helpChars[j]='Q';
                cur.add(new String(helpChars));

                solve(result, cur, n, rowCur+1, col, diag1, diag2);

                col[j]=false;
                diag1[d1]=false;
                diag2[d2]=false;
                cur.remove(cur.size()-1);
            }
        }
    }
}
