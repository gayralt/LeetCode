package main.java.offer.alogorithm;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Multiply {
    //分成两部分进行处理
    //从上到下乘一次再从下到上乘一次
    public int[] multiply(int[] A) {
        if (A.length < 1)
            return new int[0];
        int[] B = new int[A.length];
        B[0] = 1;
        int multip = 1;
        //上三角
        for (int i = 1; i < B.length; i++) {
            multip = multip * A[i - 1];
            B[i] = multip;
        }
        multip = 1;
        //下三角
        for (int i = B.length - 2; i >= 0; i--) {
            multip=multip*A[i+1];
            B[i]*=multip;
        }
        return B;
    }

    public static void main(String[] args) {
        Multiply multiply=new Multiply();
        multiply.multiply(new int[]{1,2,3,4,5});
    }
}
