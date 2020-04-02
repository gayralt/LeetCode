package main.java.Map;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class LadderLength {
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//    }

    /**
     *
     作者：littlehaes
     链接：https://leetcode-cn.com/problems/word-ladder/solution/java-31ms-ji-bai-90-shuang-xiang-bfs-xiang-xi-zhu-/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        //endWord也是transformed word, 所以必须存在于wordList中, 否则返回0, 表示无法从beginWord变成endWord
        if(!wordList.contains(endWord))
            return 0;
        //
        int n = beginWord.length();
        //key是通用状态; value是拥有该通用状态的词
        HashMap<String,ArrayList<String>>all_commons = new HashMap<>();
        //记录wordList中所有元素对应的所有通用状态
        //即wordList中变一个字母的情况
        //用hashMap作为图结构
        wordList.forEach(
                word->{
                    for(int i=0; i<n; i++){
                        String common = word.substring(0,i)+"*"+word.substring(i+1);
                        if(!all_commons.containsKey(common))
                            all_commons.put(common, new ArrayList<String>());
                        all_commons.get(common).add(word);
                    }
                }
        );
        //使用HashSet实现宽度优先遍历bfs
        HashSet<String> begin = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        //记录访问过的节点
        HashSet<String> visited = new HashSet<>();
        //细节: 返回值的初始化, 由于beginWord!=endWord, 所以至少需要一步变化
        int len = 1;
        while(!begin.isEmpty() && !end.isEmpty()){
            //核心:控制当前循环从哪个方向进行bfs; 让begin指向size更小的集合, 这样就不会一直从一个方向bfs了
            //只需两边碰撞即可 优化效率
            if(begin.size()>end.size()){
                HashSet<String> tmp = begin;
                begin = end;
                end = tmp;
            }
            //记录遍历begin时每个元素的邻居, 也就是cur的邻居
            HashSet<String> neighbor = new HashSet<>();
            for(String cur : begin){
                //遍历cur的邻居
                for(int i=0; i<n; i++){
                    String tmp = cur.substring(0,i)+"*"+cur.substring(i+1);
                    //有了all_commons哈希表,就不用每个位置都遍历'a'~'z'了
                    //细节:如果cur是beginWord的话, all_commons没有统计beginWord的通用状态, 所以all_commons.get(tmp)可能返回null, 所以要提前检查一下
                    if(!all_commons.containsKey(tmp))
                        continue;
                    for(String str : all_commons.get(tmp)){
                        if(end.contains(str))
                            return len+1;
                        if(!visited.contains(str)){
                            visited.add(str);
                            //记录cur的邻居
                            neighbor.add(str);
                        }
                    }
                }
            }
            //处理完begin中的元素后, 让begin指向begin中的元素的邻居
            begin = neighbor;
            //路径长度++
            len++;
        }
        //执行到这里说明双向bfs没有相遇, 也就是没有找到从beginWord到endWord的路径
        return 0;
    }

    public static void main(String[] args) {
        LadderLength ladderLength=new LadderLength();
        ladderLength.ladderLength2("hit","cog",Arrays.asList("hot","dot","dog","lot","log","cog"));
    }

}

