package _007_Tree;

import java.util.*;

/**
 * https://leetcode.cn/problems/implement-trie-prefix-tree/description/?envType=study-plan-v2&envId=top-interview-150
 */
class Trie {

    TrieNode head;
    static class  TrieNode{
        char ch;
        boolean last;
        Map<Character,TrieNode> children;
        TrieNode(){
            children = new HashMap<>();
        }
        TrieNode(char c){
            ch = c;
            children = new HashMap<>();
        }
    }

    public Trie() {
        head = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = head;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            boolean contains = cur.children.containsKey(ch);
            if(contains){
                cur = cur.children.get(ch);
            }else {
                TrieNode trieNode = new TrieNode(ch);
                cur.children.put(ch,trieNode);
                cur = trieNode;
            }
            if(i==word.length()-1){
                cur.last = true;
            }
        }
    }
    
    public boolean search(String word) {
        TrieNode cur = head;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.children.containsKey(word.charAt(i))) {
                return false;
            }else {
                cur = cur.children.get(word.charAt(i));
            }
        }
        return cur.last;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = head;
        for (int i = 0; i < prefix.length(); i++) {
            if (!cur.children.containsKey(prefix.charAt(i))) {
                return false;
            }else {
                cur = cur.children.get(prefix.charAt(i));
            }
        }
        return true;
    }
}