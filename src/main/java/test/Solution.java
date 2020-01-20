package main.java.test;

import sun.awt.image.ImageWatched;

import java.util.*;


public class Solution {
    private int a=1;
    private int b=2;
    {
        System.out.println("方法块");
        System.out.println(a);
        System.out.println(b);
        a=3;
        b=3;
    }

    public Solution() {
        System.out.println("构造器");
        this.a = 3;
        this.b = 4;
    }

    {
        System.out.println("方法块2");
    }
    static {
        System.out.println("静态块");
    }

    public static void main(String[] args) {
        Solution s=new Solution();
    }
}
