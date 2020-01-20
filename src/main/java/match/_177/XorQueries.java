package main.java.match._177;

public class XorQueries {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        int result;
        for (int i = 0; i < queries.length; i++) {
            result = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                result ^= arr[j];
            }
            res[i] = result;
        }
        return res;
    }

    public static void main(String[] args) {
        XorQueries queries = new XorQueries();
        queries.xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}});
    }
}
