package main.java.match._177;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FreqAlphabets {
    //栈解决
    public String freqAlphabets(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> list=new LinkedList<>();
        int num;
        String res = "";
        for (int i = chars.length-1; i >= 0; i--) {
            if (chars[i]=='#'){
                num=Integer.valueOf(""+chars[i-2]+chars[i-1]);
                i=i-2;
            }else {
                num=Integer.valueOf(""+chars[i]);
            }
            list.push((char) ('a'-1+num));
        }
        while (!list.isEmpty()){
            res+=list.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        FreqAlphabets alphabets=new FreqAlphabets();
        alphabets.freqAlphabets("1326#");
    }
}
