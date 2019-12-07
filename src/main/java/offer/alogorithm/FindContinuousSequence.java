package main.java.offer.alogorithm;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 * Good Luck!
 *
 * 输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {
    //穷举法，找最大值小于(sum+1)/2的序列
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> results=new ArrayList<>();
        ArrayList<Integer> result;
        int numSum=0;
        //查找序列
        for (int i=1;i<=((sum+1)/2);i++){
            result=new ArrayList<>();
            //以i为起始数进行查找
            for (int j = i; j <=((sum+1)/2)&&numSum<sum; j++) {
                numSum+=j;
                result.add(j);
            }
            //判断是否相等
            if (numSum==sum&&result.size()>1){
                results.add(result);
            }
            numSum=0;
        }
        return results;
    }
    //通过记录最大值，最小值指针来完成类似队列的操作
    public ArrayList<ArrayList<Integer>> findContinuousSequence2(int sum) {
//        ArrayList<ArrayList<Integer>> results=new ArrayList<>();
//        ArrayList<Integer> result=new ArrayList<>();
//        int small;
//        int big;
//        int numSum=0;
//        for (big=1,small=0;big<=((sum+1)/2)+1&&big>small;){
//            if (numSum<sum&&big<=((sum+1)/2)){
//                numSum+=big;
//                result.add(big++);
//            }else  {
//                if (small!=0&&result.size()>0)
//                    result.remove(0);
//                numSum-=small++;
//            }
//            if (numSum==sum){
//                if (numSum==sum&&result.size()>1)
//                    results.add(new ArrayList<>(result));
//                numSum-=small++;
//                result.remove(0);
//            }
//        }
//        return results;
//存放结果
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1,phigh = 2;
        while(phigh > plow){
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            }else if(cur < sum){
                phigh++;
            }else{
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        FindContinuousSequence sequence=new FindContinuousSequence();
        sequence.findContinuousSequence2(1);
    }
}