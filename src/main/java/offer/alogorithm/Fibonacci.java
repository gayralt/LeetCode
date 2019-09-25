package main.java.offer.alogorithm;

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

    public static void main(String[] args) {
        Fibonacci fibonacci=new Fibonacci();
        System.out.println(fibonacci.fibonacci(6));
    }
}
