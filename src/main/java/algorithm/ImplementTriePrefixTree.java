package main.java.algorithm;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 * 实现字典树
 *
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class ImplementTriePrefixTree {
    private TrieNode node;
    private TrieNode root;
    /** Initialize your data structure here. */
    public ImplementTriePrefixTree() {
        node=new TrieNode();
        root=node;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char c;
        for (int i=0;i<word.length();i++){
               c=word.charAt(i);
            if (node.children[c-'a']==null)
                node.children[c-'a']=new TrieNode(c);
            node=node.children[c-'a'];
        }
        node.isWord=true;
        node=root;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char c;
        boolean flag;
        for (int i=0;i<word.length();i++){
            c=word.charAt(i);
            if (node.children[c-'a']==null||node.children[c-'a'].val!=c) {
                node=root;
                return false;
            }
            node=node.children[c-'a'];
        }
        flag=node.isWord;
        node=root;
        return flag;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char c;
        for (int i=0;i<prefix.length();i++){
            c=prefix.charAt(i);
            if (node.children[c-'a']==null||node.children[c-'a'].val!=c) {
                node=root;
                return false;
            }
            node=node.children[c-'a'];
        }
        node=root;
        return true;
    }
}
