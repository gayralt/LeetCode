package main.java.offer.alogorithm;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class HasPath {
    //矩阵访问:row（当前行，从0开始）*cols+col
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //校验条件
        if (null==matrix||rows<=0||cols<=0||null==str||rows*cols<str.length)
            return false;
        boolean [] flag=new boolean[rows*cols];
        //任意一点出发
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //找到了
                if (this.findPath(matrix,i,rows,j,cols,str,0,flag))
                    return true;
            }
        }
        //没找到
        return false;
    }

    /**
     *
     * @param matrix 二维数组
     * @param row   行
     * @param col   列
     * @param str   查找的数组
     * @param currentStr 当前匹配到的索引
     * @param flag  标识数组
     * @return
     */
    private boolean findPath(char[] matrix,int row,int rows,int col,int cols,char[] str,int currentStr,boolean[] flag){

        boolean hasPath=false;
        //匹配完 返回真
        if (currentStr>=str.length)
        return true;
        if (row>=0&&col>=0&&row<rows&&col<cols&&!flag[row*cols+col]&&matrix[row*cols+col]==str[currentStr]){
            //匹配成功
            currentStr++;
            flag[row*cols+col]=true;
            //递归匹配
            hasPath=findPath(matrix,row+1,rows,col,cols,str,currentStr,flag)||
                    findPath(matrix,row,rows,col+1,cols,str,currentStr,flag)||
                    findPath(matrix,row-1,rows,col,cols,str,currentStr,flag)||
                    findPath(matrix,row,rows,col-1,cols,str,currentStr,flag);
            //匹配失败，回滚
            if (!hasPath) {
                flag[row * cols + col] = false;
                currentStr--;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        HasPath hasPath=new HasPath();
        System.out.println(hasPath.hasPath(new String("ABCESFCSADEE").toCharArray(),3,4,new String("ABCCED").toCharArray()));
    }
}
