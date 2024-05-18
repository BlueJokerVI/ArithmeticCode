package _001_shuzu;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/longest-common-prefix/?envType=study-plan-v2&envId=top-interview-150
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==1) {
            return strs[0];
        }


        String  origin = strs[0];
        for(int i=1;i<=origin.length();i++){
            String suba = origin.substring(0, i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<i){
                    return origin.substring(0,i-1);
                }
                String subb = strs[j].substring(0, i);
                if(!subb.equals(suba)){
                    return origin.substring(0,i-1);
                }
            }
        }

        return origin;
    }



    //字典树
    class Solution {
        TrieNode root = new TrieNode();
        public String longestCommonPrefix(String[] strs) {

            String ans = strs[0];
            int minLen = strs[0].length();
            insert(strs[0]);
            for(int i=1;i<strs.length;i++){
                String res = find(strs[i]);
                if(res.equals("")){
                    ans = "";
                    break;
                }
                if(res.length()<minLen){
                    minLen = res.length();
                    ans = res;
                }
            }

            return ans;

        }

        public void insert(String s){

            TrieNode p = root;

            for(int i=0;i<s.length();i++){

                int index = s.charAt(i)-'a';
                if(p.children[index] == null){
                    p.children[index] = new TrieNode();
                }
                p = p.children[index];
            }

            p.isEnd = true;
        }

        public String find(String s){
            TrieNode p = root;
            StringBuilder sb = new StringBuilder();

            for(int i=0;i<s.length();i++){

                int index = s.charAt(i)-'a';
                if(p.children[index] == null){
                    break;
                }

                sb.append(s.charAt(i));
                p = p.children[index];
                if(p.isEnd){
                    break;
                }
            }

            return sb.toString();

        }

        class TrieNode{
            boolean isEnd;
            TrieNode[]children = new TrieNode[26];
        }
    }
}
