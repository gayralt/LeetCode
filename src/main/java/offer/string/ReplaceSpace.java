package main.java.offer.string;

public class ReplaceSpace {
    //新建一个StringBuffer遍历一次
    //T(N) S(N)
    public String replaceSpace(StringBuffer str) {
        if (!valid(str))
            return String.valueOf(str);
        StringBuffer newStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (" ".equals(c + ""))
                newStr.append("%20");
            else
                newStr.append(c);
        }
        return String.valueOf(newStr);
    }

    //T（N） S（1）统计空格数量，从后往前复制
    public String replaceSpace2(StringBuffer str) {
        if (!valid(str))
            return String.valueOf(str);
        int spaceCount = 0;
        //统计空格数
        for (int i = 0; i < str.length(); i++) {
            if (" ".equals(""+str.charAt(i))) {
                spaceCount++;
            }
        }
        int oldIndex = str.length() - 1;
        int newLength = str.length() + spaceCount * 2;
        int newIndex = newLength - 1;
        //设置新长度
        str.setLength(newLength);
        //循环，将旧字符移到新位置，碰上空格则写上%20
        for (int i = oldIndex; i >= 0 && i < newIndex; i--) {
            if (" ".equals(""+str.charAt(oldIndex))){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
                oldIndex--;
            }else {
                str.setCharAt(newIndex--,str.charAt(oldIndex));
                oldIndex--;
            }
        }
        //返回
        return String.valueOf(str);
    }

    private boolean valid(StringBuffer str) {
        if (null == str || str.length() <= 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        replaceSpace.replaceSpace2(new StringBuffer("We Are Happy."));
    }
}
