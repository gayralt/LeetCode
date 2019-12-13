package main.java.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 示例 1:
 *
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 示例 2:
 *
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 示例 3:
 *
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 */
public class FractionToDecimal {
    //竖式法
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator==0)
            return "0";
        //整数部分计算
        StringBuilder stringBuilder=new StringBuilder();
        if((numerator^denominator)<0)
            stringBuilder.append("-");
        long dividend=Math.abs(Long.valueOf(numerator));
        long divisor=Math.abs(Long.valueOf(denominator));
        stringBuilder.append(String.valueOf(dividend/divisor));
        //余数
        long remainder=dividend%divisor;
        if (remainder==0)
            return stringBuilder.toString();
        stringBuilder.append(".");
        //小数部分计算
        HashMap<Long,Integer> map=new HashMap<>();
       while (remainder!=0){
           if (map.containsKey(remainder)){
               stringBuilder.insert(map.get(remainder),"(");
               stringBuilder.append(")");
               break;
           }
           //余数加入map
           map.put(remainder,stringBuilder.length());
           //余数*10
           remainder*=10;
           //增加结果
           stringBuilder.append(String.valueOf(remainder/divisor));
           //余数
           remainder%=divisor;
       }
       return stringBuilder.toString();
    }
}
