package main.java.algorithm;

public class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children=new TrieNode[26];

    public TrieNode() {
    }

    public TrieNode(char val) {
        this.val = val;
    }
}
