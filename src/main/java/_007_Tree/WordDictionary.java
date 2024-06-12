package _007_Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/design-add-and-search-words-data-structure/description/?envType=study-plan-v2&envId=top-interview-150
 */
class WordDictionary {

    WordNode head;

    class WordNode{
        char ch;
        boolean last;
        Map<Character, WordNode> children;
        WordNode(){
            children = new HashMap<>();
        }
        WordNode(char c){
            ch = c;
            children = new HashMap<>();
        }
    }
    public WordDictionary() {
        head = new WordNode();
    }
    
    public void addWord(String word) {
        WordNode cur = head;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.children.containsKey(c)){
                cur = cur.children.get(c);
            }else {
                WordNode child = new WordNode(c);
                cur.children.put(c,child);
                cur = child;
            }

            if(i==word.length()-1){
                cur.last = true;
            }
        }
    }
    
    public boolean search(String word) {
        return searchDFS(word,0,head);
    }

    private boolean searchDFS(String word,int index,WordNode cur){

        char c = word.charAt(index);

        if(index==word.length()-1){
            if(c=='.'){
                for (WordNode value : cur.children.values()) {
                    if(value.last){
                        return true;
                    }
                }
                return false;
            }else {
                return cur.children.containsKey(c) && cur.children.get(c).last;
            }
        }


        if(c!='.'){
            return cur.children.containsKey(c) && searchDFS(word, index + 1, cur.children.get(c));
        }else {
            boolean find = false;
            for (WordNode wordNode : cur.children.values()) {
                if (searchDFS(word,index+1,wordNode)) {
                    find = true;
                }
            }
            return find;
        }
    }
}
