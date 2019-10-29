package main.java.offer.alogorithm;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    //使用异或法（相同数字异或为0，偶数次才可用）空间复杂度O（1），时间复杂度O(n)
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length<=0)
            return;
        int indexOfNum=array[0];
        //求取异或值
        for (int i = 1; i < array.length; i++) {
            indexOfNum^=array[i];
        }
        //得到某一位为1，根据该位将两个只出现一次的数字分开
        int index=findIndex(indexOfNum);
        //0与任何数异或结果都为那个数
        num1[0]=0;
        num2[0]=0;
        //各自得出只出现一次的数字
        for (int num:array) {
            //根据该数二进制某个位是否为1来划分，分别异或
            if (checkNum(num,index)){
                num1[0]^=num;
            }else {
                num2[0]^=num;
            }
        }
    }
    //找第几位是1
    private int findIndex(int index){
        int count=0;
        for (int i = 0; i < 32&&((index&1)!=1); i++) {
            index=index>>1;
            count++;
        }
        return count;
    }
    //平移n位
    private boolean checkNum(int num,int index){
        num=num>>index;
        return (num&1)==1;
    }

    public static void main(String[] args) {
        FindNumsAppearOnce once=new FindNumsAppearOnce();
        once.findNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5},new int[1],new int[1]);
    }
}
