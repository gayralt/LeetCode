package main.java.offer.alogorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class IsContinuous {
    //1. 排序
    //2. 找0的个数
    //3. 查看空缺，若有相等则直接退出
    public boolean isContinuous(int [] numbers) {
        if (numbers.length<5)
            return false;

        Arrays.sort(numbers);
        int zeroIndex=0;
        for (int i = 0; i < numbers.length&&numbers[i]==0; i++) {
                zeroIndex++;
        }
        int empty=0;
        for (int i = zeroIndex; i < numbers.length-1; i++) {
            if (numbers[i]==numbers[i+1])
                return false;
            empty+=numbers[i+1]-numbers[i]-1;
        }
        return empty<=zeroIndex?true:false;
    }

    /**
     * 查找最大值和最小值，
     * 差值小于5，且数量为5个，则正确
     * 0则跳出统计
     * @param numbers
     * @return
     */
    public boolean isContinuous2(int [] numbers) {
        if (numbers.length<5)
            return false;

        int[]d = new int[14];
        d[0] = -5;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for(int i =0;i<len;i++){
            d[numbers[i]]++;
            if(numbers[i] == 0){
                continue;
            }
            if(d[numbers[i]]>1){
                return false;
            }
            if(numbers[i] >max){
                max = numbers[i];
            } if(numbers[i] <min){
                min = numbers[i];
            }

        }
        if(max -min<5){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        IsContinuous continuous=new IsContinuous();
        continuous.isContinuous(new int[]{1,3,0,0,5});
    }
}
