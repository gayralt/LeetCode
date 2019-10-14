package main.java.offer.alogorithm;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    //建一个新数组
    public void reOrderArray(int [] array) {
        if (array==null)
            return;
        int swap=0;
        int [] newArray=new int[array.length];
        for (int i = 0,k=0,j=array.length-1; i <array.length&&k<=j;i++) {
            //偶数
            if ((array[array.length-i-1]&1)==0){
               newArray[j]=array[array.length-i-1];
               j--;
            }//奇数
            if ((array[i]&1)==1){
                newArray[k]=array[i];
                k++;
            }
        }
        for (int i=0;i<array.length;i++){
            array[i]=newArray[i];
        }
    }
    public static void main(String[] args) {
        ReOrderArray re=new ReOrderArray();
        re.reOrderArray(new int[]{1,2,3,4,5,6,7});
    }
}
