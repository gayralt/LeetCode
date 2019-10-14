package main.java.offer.alogorithm;

/**
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 输出描述:
 * 输出答案。
 * 示例1
 * 输入
 * 8
 * 输出
 * 18
 */
public class CutRope {
    //动态规划辅助
    //f(n)=max(f(i)*f(n-i))假设每段都先分两段，在递归分下去
    public int cutRope(int target) {
        if (target<2)
            return 0;
        if (target==2)
            return 1;
        if (target==3)
            return 2;
        int[] product=new int[target+1];
        int max;
        /**
         * 下面3行是n>=4的情况，跟n<=3不同，4可以分很多段，比如分成1、3，
         *  这里的3可以不需要再分了，因为3分段最大才2，不分就是3。记录最大的。
         */
        product[0]=0;
        product[1]=1;
        product[2]=2;
        product[3]=3;
        for (int i = 4; i < product.length; i++) {
            max=0;
            for (int j = 1; j <= product.length/2; j++) {
                int res=product[j]*product[i-j];
                if (max<res)
                    max=res;
                //更新最大值
                product[i]=max;
            }
        }
        max=product[target];
        return max;
    }
    //贪婪法
    //结果有规律，分解后最大值为大量3与至多2个2的乘积
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/57d85990ba5b440ab888fc72b0751bf8?f=discussion
     * * 4 ： 2*2
     *  * 5 ： 2*3
     *  * 6 ： 3*3
     *  * 7 ： 2*2*3 或者4*3
     *  * 8 ： 2*3*3
     *  * 9 ： 3*3*3
     *  * 10：2*2*3*3 或者4*3*3
     *  * 11：2*3*3*3
     *  * 12：3*3*3*3
     *  * 13：2*2*3*3*3 或者4*3*3*3
     * @param target
     * @return
     */
    public int cutRope1(int target) {
        if(target<2)return 0;
        if (target==2)return 1;
        if (target==3)return 2;
        //尽可能多地剪去长度为3的绳子段
        //3的个数
        int timesOf3=target/3;
        //当绳子为4的时候，不能再剪去长度为3的绳子段
        //此时因分解为2个2
        if (target-timesOf3*3==1)
            timesOf3--;
        //2的个数
        int timeOf2=(target-timesOf3*3)/2;

        return (int) (Math.pow(3,timesOf3)*Math.pow(2,timeOf2));
    }
    public static void main(String[] args) {
        CutRope cutRope=new CutRope();
        System.out.println(cutRope.cutRope(8));
    }
}
