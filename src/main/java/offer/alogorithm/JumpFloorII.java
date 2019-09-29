package main.java.offer.alogorithm;

import java.util.ArrayList;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 每一级的跳法相加再加1(0级的跳法)，每一级既可以直接跳到n级，也可以跳到后面的级数再跳到n级，不会重复
 */
public class JumpFloorII {
    public int JumpFloorII(int target) {
        if (target<=0)
            return 0;
        int[] result=new int[target+2];
        result[0]=1;
        result[1]=2;
        if (target>=2){
            for (int i = 2; i < target; i++) {
                for (int j=0;j<i;j++){
                    //前面数相加
                    result[i]+=result[j];
                }
                //0级跳法
                result[i]++;
            }
        }
        return result[target-1];
    }

    /**
     * f(n)=f(n-1)+f(n-2)+...+f(1)
     * f(n-1)=f(n-2)+...f(1)
     * 得:f(n)=2*f(n-1)
     * f(n)=2^1*f(n-2)
     * ……
     * 最后
     * f（n）=2^(n-1)
     * @param target
     * @return
     */
    public int JumpFloorII2(int target) {
        //1左移动target-1位，即2^(n-1)
        return 1<<(target-1);
        //return (int)Math.pow(2,target-1);
    }
    public static void main(String[] args) {
        JumpFloorII jumpFloorII=new JumpFloorII();
        System.out.println(jumpFloorII.JumpFloorII2(4));
    }
}
