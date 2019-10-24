package main.java.offer.alogorithm;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 题目保证输入的数组中没有的相同的数字
 *
 * 数据范围：
 *
 * 	对于%50的数据,size<=10^4
 *
 * 	对于%75的数据,size<=10^5
 *
 * 	对于%100的数据,size<=2*10^5
 *
 */
public class InversePairs {
    //利用归并排序统计逆序对，归并中间需要排序时逆序对数量+1
    //合并时，从后面开始比较，如果后面数组的值小于前面数组的值，说明该数组都小于前面数组的某个值
    public int inversePairs(int [] array) {
        if (null==array||array.length<=1)
            return 0;
        int[] copy=new int[array.length];
        return inverse(0,array.length-1,array,copy);
    }
    //归并数组
    private int inverse(int start,int end,int[] array,int[] copy){
        if (start==end)
            return 0;
        int count=0;
        int length=(end-start)>>1;
        //递归
        int left=inverse(start,start+length,array,copy);
        int right=inverse(start+length+1,end,array,copy);
        int i=start+length;
        int j=end;
        int copyIndex=end;
        while (i>=start&&j>=start+length+1){
         if (array[i]>array[j]){
             copy[copyIndex--]=array[i--];
             count+=j-(start+length);
             if(count>=1000000007)//数值过大求余
             {
                 count%=1000000007;
             }
         }else {
             copy[copyIndex--]=array[j--];
         }
        }
        //剩余
        while (i>=start){
            copy[copyIndex--]=array[i--];
        }
        //剩余
        while (j>=start+length+1){
            copy[copyIndex--]=array[j--];
        }
        for(int s=start;s<=end;s++)
        {
            array[s] = copy[s];
        }
        return (left+right+count)%1000000007;
    }



//    public int inversePairs(int [] array) {
//        if (null==array||array.length<=1)
//            return 0;
//        int[] copy=new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            copy[i]=array[i];
//        }
//        return inverse(0,array.length-1,array,copy);
//    }
//    //归并数组
//    private int inverse(int start,int end,int[] array,int[] copy){
//        if (start==end){
//            copy[start]=array[start];
//            return 0;
//        }
//        int length=(end-start)/2;
//
//        int left=inverse(start,start+length,array,copy);
//        int right=inverse(start+length+1,end,array,copy);
//
//        //前半段最后一个数字下标
//        int i=start+length;
//        //后半段最后一个数字下标
//        int j=end;
//        int indexCopy=end;
//        int count=0;
//        //前半段与后半段
//        while (i>=start&&j>start+length+1){
//            //前半段与后半端，末尾开始比较
//            if (array[i]>array[j]){
//                copy[indexCopy--]=array[i--];
//                count+=j-start-length;
//            }else {
//                copy[indexCopy--]=array[j--];
//            }
//        }
//        for (;i>=start;--i)
//            copy[indexCopy--]=array[i];
//        for (;j>=start+length+1;--j)
//            copy[indexCopy--]=array[j];
//        return left+right+count;
//    }

    public static void main(String[] args) {
        InversePairs pairs=new InversePairs();
        pairs.inversePairs(new int[]{7,4,5,6});
    }
}
