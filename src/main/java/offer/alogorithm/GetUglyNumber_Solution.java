package main.java.offer.alogorithm;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber_Solution {
    //记录前面丑数的值(下一个丑数为之前某一个小于当前丑数的数的2/3/5倍，各自作标识，记录某个数*2/3/5后小于当前数的最大值),动态规划
    public int getUglyNumber_Solution(int index) {
        if (index<=0)
            return 0;
        int[] uglyNumbers=new int[index];
        uglyNumbers[0]=1;
        int nextUglyNumber=1;
        int multip2=0;
        int multip3=0;
        int multip5=0;

        while (nextUglyNumber<index){
            //取前面丑数乘上2/3/5的最小值
            uglyNumbers[nextUglyNumber]=my_min(uglyNumbers[multip2]*2,uglyNumbers[multip3]*3,uglyNumbers[multip5]*5);
            //标识数更新，记录小于当前丑数的最大标识
            while (uglyNumbers[multip2]*2<=uglyNumbers[nextUglyNumber])
                multip2++;
            while (uglyNumbers[multip3]*3<=uglyNumbers[nextUglyNumber])
                multip3++;
            while (uglyNumbers[multip5]*5<=uglyNumbers[nextUglyNumber])
                multip5++;
            nextUglyNumber++;
        }
        //结果为最末尾的数
        int ugly=uglyNumbers[index-1];
        return ugly;
    }
    private int my_min(int first,int second,int third){
        int min;
        min=first>second?second:first;
        min=min>third?third:min;
        return min;
    }

    public static void main(String[] args) {
        GetUglyNumber_Solution solution=new GetUglyNumber_Solution();
        solution.getUglyNumber_Solution(5);
    }
}
