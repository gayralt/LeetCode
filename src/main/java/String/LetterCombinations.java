package main.java.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        Map<Character,List<Character>> map=new HashMap<>();
        List<Character> two=new ArrayList<>();
        two.add('a');two.add('b');two.add('c');
        List<Character> three=new ArrayList<>();
        three.add('d');three.add('e');three.add('f');
        List<Character> four=new ArrayList<>();
        four.add('g');four.add('h');four.add('i');
        List<Character> five=new ArrayList<>();
        five.add('j');five.add('k');five.add('l');
        List<Character> six=new ArrayList<>();
        six.add('m');six.add('n');six.add('o');
        List<Character> seven=new ArrayList<>();
        seven.add('p');seven.add('q');seven.add('r');seven.add('s');
        List<Character> eight=new ArrayList<>();
        eight.add('t');eight.add('u');eight.add('v');
        List<Character> night=new ArrayList<>();
        night.add('w');night.add('x');night.add('y');night.add('z');
        map.put('2',two);
        map.put('3',three);
        map.put('4',four);
        map.put('5',five);
        map.put('6',six);
        map.put('7',seven);
        map.put('8',eight);
        map.put('9',night);
        List<String> result=new ArrayList<>();
        build(digits,0,map,result,"");
        return result;
    }
    private void build(String digits,int index,Map<Character,List<Character>> map,List<String> result,String s){
        if (index>=digits.length())
            return;
        List<Character> characters=map.get(digits.charAt(index));
        if (characters==null)
            return;
        for (int i = 0; i < characters.size(); i++) {
            String newString=s+characters.get(i);
            if (index==digits.length()-1){
                result.add(newString);
            }else {
                build(digits,index+1,map,result,newString);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinations combinations=new LetterCombinations();
        combinations.letterCombinations("23");
    }
}
