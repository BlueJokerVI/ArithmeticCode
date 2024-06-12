package _007_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/word-search-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class FindWords {

    private Words words = new Words();
    private boolean[][] vis;
    private StringBuilder cur = new StringBuilder();
    int m;
    int n;
    public List<String> findWords(char[][] board, String[] ws) {
        m = board.length;
        n = board[0].length;
        vis = new boolean[m][n];
        Arrays.fill(vis,false);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(i,j,board);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String w : ws) {
            if (words.find(w)) {
                ans.add(w);
            }
        }

        return ans;
    }


    void dfs(int i,int j,char[][] board){
        //终止条件加减枝
        if(i<0 || i>=m || j<0 || j>=n || vis[i][j] || cur.length()>=10){
            return;
        }

        vis[i][j] = true;
        cur.append(board[i][j]);
        words.insert(cur.toString());
        dfs(i+1,j,board);
        dfs(i-1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);
        vis[i][j] = false;
        cur.setLength(cur.length()-1);
    }

    class Words{
        Node head;
        class Node{
            char ch;
            Node[] childern = new Node[26];
            boolean last;
            Node(){}
            Node(char c){
                ch = c;
            }
        }
        Words(){
            head = new Node();
        }

        void insert(String word){
            Node cur = head;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.childern[c - 'a'] == null) {
                    cur.childern[c - 'a'] = new Node(c);
                }
                cur = cur.childern[c-'a'];
                if(i==word.length()-1){
                    cur.last = true;
                }
            }
        }

        boolean find(String word){
            Node cur = head;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.childern[c - 'a'] == null) {
                    return false;
                }
                cur = cur.childern[c-'a'];
            }
            return cur.last;
        }
    }


    //拿words建立前缀树，再board内找
    public class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            int m = board.length;
            if (m == 0) return res;
            int n = board[0].length;
            if (n == 0) return res;

            TrieNode root = new TrieNode();
            for (String word : words)
                buildTrie(word, root);

            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    dfs(board, i, j, root, res);

            return res;
        }

        private void dfs(char[][] board, int r, int c, TrieNode node, List<String> res) {
            if (board[r][c] == '#')
                return;

            int v = board[r][c] - 'a';
            if (node.children[v] == null)
                return;

            node = node.children[v];
            if (node.word != null) {
                res.add(node.word);
                node.word = null;
            }

            int m = board.length;
            int n = board[0].length;
            char tmp = board[r][c];
            board[r][c] = '#';
            if (r > 0)
                dfs(board, r-1, c, node, res);
            if (r < m-1)
                dfs(board, r+1, c, node, res);
            if (c > 0)
                dfs(board, r, c-1, node, res);
            if (c < n-1)
                dfs(board, r, c+1, node, res);
            board[r][c] = tmp;
        }

        private void buildTrie(String word, TrieNode node) {
            for (char c : word.toCharArray()) {
                int v = c - 'a';
                if (node.children[v] == null)
                    node.children[v] = new TrieNode();
                node = node.children[v];
            }
            node.word = word;
        }

        class TrieNode {
            TrieNode[] children;
            String word; //叶子节点存了整条记录
            public TrieNode() {
                children = new TrieNode[26];
                word = null;
            }
        }
    }

}


