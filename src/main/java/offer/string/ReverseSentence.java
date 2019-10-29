package main.java.offer.string;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {
    //二次逆转
    public String reverseSentence(String str) {
        if (null == str || str.length() < 2)
            return str;
        char[] chars = str.toCharArray();
        int start = 0;
        int end = 0;
        //每个词都逆转一次
        for (int i = 0; i <chars.length; i++) {
            //单词
            if (chars[i] == ' ') {
                reverse(chars, start, end - 1);
                start = 1 + end++;
            }//句尾
            else if (chars[i] == '.'||i==chars.length-1) {
                reverse(chars, start, end);
            } else {
                end++;
            }
        }
        //整句话逆转
        reverse(chars, 0, str.length() - 1);
        return String.valueOf(chars);
//        链接：https://www.nowcoder.com/questionTerminal/3194a4f4cf814f63919d0790578d51f3?f=discussion
//        来源：牛客网
//
//        char[] chars = str.toCharArray();
//        reverse(chars,0,chars.length - 1);
//        int blank = -1;
//        for(int i = 0;i < chars.length;i++){
//            if(chars[i] == ' '){
//                int nextBlank = i;
//                reverse(chars,blank + 1,nextBlank - 1);
//                blank = nextBlank;
//            }
//        }
//        reverse(chars,blank + 1,chars.length - 1);//最后一个单词单独进行反转
//        return new String(chars);
    }

    private void reverse(char[] str, int start, int end) {
        char change;
        while (start < end && end < str.length && end >= 0) {
            change = str[start];
            str[start++] = str[end];
            str[end--] = change;
        }
    }

    public static void main(String[] args) {
        ReverseSentence sentence = new ReverseSentence();
        sentence.reverseSentence("I am a student.");
    }
}
