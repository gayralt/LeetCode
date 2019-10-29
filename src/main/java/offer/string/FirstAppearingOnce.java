package main.java.offer.string;

import java.util.*;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class FirstAppearingOnce {
    Map<Character,Integer> chars = new HashMap<>();
    Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void insert(char ch) {
        if (!chars.containsKey(ch)) {
            chars.put(ch,1);
            queue.offer(ch);
        }else {
            chars.replace(ch,chars.get(ch)+1);
            while (!queue.isEmpty() && chars.get(queue.peek())>1) {
                queue.poll();
            }
        }
    }

    //return the first appearence once char in current stringstream
    public char firstAppearingOnce() {
        return queue.isEmpty()?'#':queue.peek();
    }

    public static void main(String[] args) {
        FirstAppearingOnce once=new FirstAppearingOnce();
        once.insert('g');
        System.out.println(once.firstAppearingOnce());
        once.insert('o');
        System.out.println(once.firstAppearingOnce());
        once.insert('o');
        System.out.println(once.firstAppearingOnce());
        once.insert('g');
        System.out.println(once.firstAppearingOnce());
        once.insert('l');
        System.out.println(once.firstAppearingOnce());
        once.insert('e');
        System.out.println(once.firstAppearingOnce());
    }
}
