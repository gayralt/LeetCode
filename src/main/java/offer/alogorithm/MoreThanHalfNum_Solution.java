package main.java.offer.alogorithm;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次
 * ，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution {
    private Integer num = 0;
    private Integer times = 0;

    //遍历 有重复数字+1，不是-1，为0换一个数字
    public int MoreThanHalfNum_Solution(int[] array) {
        this.num=array[0];
        this.times=1;
        if (null==array||array.length<=0)
        return 0;
        for (int i = 1; i < array.length;i++) {
            if (array[i]==this.num){
                this.times++;
            }else if (array[i]!=this.num){
                this.times--;
                if (this.times<=0){
                    this.num=array[i];
                    this.times=1;
                }
            }
        }
        //检查是否为次数大于一半的数(用于可能没重复数字的情况)
        int checkTimes=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==this.num)
                checkTimes++;
        }
        return checkTimes>(array.length/2)?this.num:0;
    }

    public static void main(String[] args) {
        MoreThanHalfNum_Solution moreThanHalfNum_solution=new MoreThanHalfNum_Solution();
        moreThanHalfNum_solution.MoreThanHalfNum_Solution(new int[]{1,2,3,2,4,2,5,2,3});
    }
}
