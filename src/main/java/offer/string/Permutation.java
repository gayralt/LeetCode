package main.java.offer.string;

import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {
    private ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> permutation(String str) {
        if (str.length() <= 0)
            return new ArrayList<String>(new TreeSet<String>(result));
        //定义数组
        char[] chars = new char[str.length()];
        boolean[] flags=new boolean[str.length()];
        //递归
        printStr(chars, 0, str,flags);
        return new ArrayList<String>(new TreeSet<String>(result));
    }

    private void printStr(char[] chars, Integer index, String str,boolean[] flags) {
        //末尾添加到结果
        if (chars.length == index) {
            result.add(new String(chars));
            return;
        }
        //循环取所有可能性，递归
        for (int i = 0; i < str.length(); i++) {
            if (!flags[i]) {
                chars[index] = str.charAt(i);
                flags[i]=true;
                printStr(chars, index + 1, str, flags);
                flags[i]=false;
            }
        }
    }

    //递归交换完成全排序
    public ArrayList<String> Permutation(String str){

        ArrayList<String> list = new ArrayList<String>();
        if(str!=null && str.length()>0){
            PermutationHelper(str.toCharArray(),0,list);
            //自然排序
            Collections.sort(list);
        }
        return list;
    }
    private void PermutationHelper(char[] chars,int i,ArrayList<String> list){
        if(i == chars.length-1){
            //满足条件添加到list里面
            list.add(String.valueOf(chars));
        }else{
            //每个栈(每个层次)记录已经与char[i]交换的字符
            Set<Character> charSet = new HashSet<Character>();
            //循环交换字符，递归交换下一个字符
            for(int j=i;j<chars.length;++j){
                //当前没交换过，交换，递归到下一层
                if(j==i || !charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    PermutationHelper(chars,i+1,list);
                    swap(chars,j,i);
                }
            }
        }
    }

    private void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
    public static void main(String[] args) {
        Permutation permutation=new Permutation();
        System.out.println(permutation.Permutation("aab"));
        System.out.println(permutation.Permutation("abc"));

    }
}
