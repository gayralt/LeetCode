package main.java.offer.string;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 分三部分，整数，小数，以及指数
 */
public class IsNumeric {
    public boolean isNumeric(char[] str) {
        if (null==str||str.length<=0)
            return false;
        //检测整数
        int index=this.isInteger(str,0);

        //检查小数
        if (index>0&&index<str.length&&str[index]=='.'){
            index=this.isNumber(str,index+1);
        }

        //检查指数
        if (index>0&&index<str.length&&(str[index]=='e'||str[index]=='E')){
            index=this.isInteger(str,index+1);
        }
        return index==str.length;
    }
    private int isInteger(char[] str,int index){
        //检查是否有正负号
        if (index>=0&&index<str.length&&(str[index]=='+'||str[index]=='-'))
            index++;
        return this.isNumber(str,index);
    }
    private int isNumber(char[] str,int index){
        //检查不了数字
        if (index==str.length)
        return -1;
        //检查数字
        while (index>=0&&index<str.length&&str[index]>='0'&&str[index]<='9'){
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        IsNumeric numeric=new IsNumeric();
        System.out.print(numeric.isNumeric((new String("1 ")).toCharArray()));
    }
}
