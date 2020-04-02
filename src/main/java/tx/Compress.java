package main.java.tx;

import java.util.Scanner;

/**
 * 小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
 *
 * 输入描述:
 * 输入第一行包含一个字符串s，代表压缩后的字符串。
 * S的长度<=1000;
 * S仅包含大写字母、[、]、|;
 * 解压后的字符串长度不超过100000;
 * 压缩递归层数不超过10层;
 *
 * 输出描述:
 * 输出一个字符串，代表解压后的字符串。
 *
 * 输入例子1:
 * HG[3|B[2|CA]]F
 *
 * 输出例子1:
 * HGBCACABCACABCACAF
 *
 * 例子说明1:
 * HG[3|B[2|CA]]F−>HG[3|BCACA]F−>HGBCACABCACABCACAF
 */
public class Compress {
    public String compassString(int num,String s){
        if(s==null||s.length()<=0)
            return "";
        int start=0;
        int end=s.length()-1;
        //按顺序找【】然后拼接 然后继续找 直到到达尾部
        while (start<end){
            if (s.charAt(start)!='[')
                start++;
            if (s.charAt(end)!=']')
                end--;
            if (s.charAt(start)=='['&&s.charAt(end)==']')
                break;
        }
        String res="";
        String repeat="";
        //看是否有[]
        if (start<end){
            int new_num=getInt(s,start+1);
            int sStart=start;
            while (s.charAt(sStart)!='|')
            sStart++;
            String new_s=s.substring(sStart+1,end);
//                s=s.substring(0,start)+compassString(new_num,new_s)+s.substring(end+1,s.length());
            repeat=s.substring(0,start)+compassString(new_num,new_s)+s.substring(end+1,s.length());
        }
        for (int i = 0; i < num; i++) {
                res+=repeat.length()>0?repeat:s;
        }
        return res.length()>0?res:s;
    }
    private int getInt(String s,int start){
        String num="";
        while (s.charAt(start)>='0'&&s.charAt(start)<='9'){
            num+=s.charAt(start++);
        }
        return Integer.valueOf(num);
    }
    public static void main(String[] args) {
        Compress compress=new Compress();
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            String s=scanner.next();
            System.out.println(compress.compassString(1, s));
        }
    }
}
