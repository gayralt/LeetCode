package main.java.offer.alogorithm;

import java.util.concurrent.locks.ReentrantLock;

public class Fibonacci {
    public int fibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        int lastOne = 1;
        int lastTwo = 1;

        for (int i = 3; i <= n; i++) {
            if ((i & 1) == 1)
                lastOne = lastTwo + lastOne;
            else
                lastTwo = lastTwo + lastOne;
        }
        return lastTwo>lastOne?lastTwo:lastOne;
    }

    /**
     * 通项公式 O（1）解，F（n）=1/5^(0.5)*(((1+5^0.5)/2)^n-((1-5^0.5)/2)^n)
     * @param n
     * @return
     */
    public int fibonacci2(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        double five=Math.pow(5,0.5);
        return (int) ((1.0/five)*(Math.pow((1.0+five)/2.0,n)-Math.pow((1.0-five)/2.0,n)));
    }
    public static void main(String[] args) {
        Fibonacci fibonacci=new Fibonacci();
        System.out.println(fibonacci.fibonacci(45));
    }
}
