package main.java.offer.string;

/**
 *将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * +2147483647
 *     1a33
 * 输出
 * 2147483647
 *     0
 */
public class StrToInt {
    public int strToInt(String str) {
        if (null==str||str.length()<1)
            return 0;
        int index=0;
        long result=0L;
        //判别符号
        if (str.charAt(0)=='+'||str.charAt(0)=='-')
            index++;
        //转换
        for (;index < str.length(); index++) {
            if (str.charAt(index)>='0'&&str.charAt(index)<='9'){
                result*=10;
                result+=str.charAt(index)-'0';
            }else {
                return 0;
            }
        }
        //检测边界值
        if ((str.charAt(0)!='-'&&result>Integer.MAX_VALUE)||(str.charAt(0)=='-'&&(-result)<Integer.MIN_VALUE))
            return 0;
        //为负则取负值
        if (str.charAt(0)=='-'&&result>0)
            result=-result;

        return (int) result;
    }

    public static void main(String[] args) {
        StrToInt i=new StrToInt();
        i.strToInt("2147483648");
        //"2147483649"
    }
}
