package main.java.math;

public class NextGreaterElement {
    public int nextGreaterElement(int n) {
        if(n==Integer.MAX_VALUE||n<0)return -1;
            //获得字符数组
        char[] c=String.valueOf(n).toCharArray();
        //从后往前找到递减的数
        //将该数与右部分比它小的最大数交换
        //交换后逆置后面的部分
        int start=-1;
        for(int i=c.length-1;i>=0;i--){
            if(c[i]>c[i-1]) {
                start=i-1;
                break;
            }
        }
        if (start==-1)return -1;
        //获得递减的数
        for (int i = c.length-1; i >start ; i--) {
            if(c[i]>c[start]) {
                swap(c,start,i);
                break;
            }
        }
        //逆置 把大的数字放后面
        reverse(c,start+1,c.length-1);
        long res=Long.valueOf(String.valueOf(c));
        return res>Integer.MAX_VALUE?Integer.MAX_VALUE: (int) res;
    }
    //交换
    private void swap(char[] array,int i,int j){
        char change=array[i];
        array[i]=array[j];
        array[j]=change;
    }
    //逆置
    private void reverse(char[] array,int start,int end){
        while (start<end){
            char change=array[start];
            array[start++]=array[end];
            array[end--]=change;
        }
    }

    public static void main(String[] args) {
        NextGreaterElement next=new NextGreaterElement();
        next.nextGreaterElement(1234);
    }
}
