package main.java.offer.alogorithm;

import java.util.HashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) {
        if (str.length()<=0)
            return -1;

        HashMap<Character,Integer> map=new HashMap<>();
        for (Character value:str.toCharArray()) {
            //之前已有 +1
            if (map.containsKey(value)){
                map.replace(value,map.get(value)+1);
            }//没有放入
            else {
                map.put(value,1);
            }
        }
        int index=-1;
        //查找第一个出现次数为1的数
        for (int i=0;i<str.length();i++){
            Character value=str.charAt(i);
            if (map.get(value)==1){
                index=i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar c=new FirstNotRepeatingChar();
        c.firstNotRepeatingChar(new String("asdasdafaifzhauihdwad"));
    }
}
