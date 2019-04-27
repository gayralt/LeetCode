package main.java.stack;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.LinkedList;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 *
 *给定两个字符串s和t，当它们都被输入空文本编辑器时，返回是否相等。
 * *#表示退格字符。
 *
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        LinkedList linkedList1=new LinkedList();
        LinkedList linkedList2=new LinkedList();
        for (int i=0;i<S.length();i++){
            if (S.charAt(i)=='#'){
                if (linkedList1.size()>0)
                linkedList1.pop();
            }else {
                linkedList1.push(S.charAt(i));
            }
        }
        for(int i=0;i<T.length();i++){
            if (T.charAt(i)=='#'){
                if (linkedList2.size()>0)
                linkedList2.pop();
            }else {
                linkedList2.push(T.charAt(i));
            }
        }
        if (linkedList1.equals(linkedList2)){
            return true;
        }
        return false;
    }
}
