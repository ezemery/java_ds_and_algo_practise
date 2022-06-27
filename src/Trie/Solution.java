package Trie;

public class Solution {
    class TrieNode{
        char c;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(char _c){
            this.c = _c;
            this.children = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode(' ');

    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children[c - 'a'] == null){
                return false;
            }else{
                node = node.children[c - 'a'];
            }
        }

        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if(node.children[c - 'a'] == null){
                return false;
            }else{
                node = node.children[c - 'a'];
            }
        }

        return true;
    }
}
