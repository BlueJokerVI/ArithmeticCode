package _001_shuzu;

import org.junit.Test;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseWords {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        reverse(chars,0,chars.length-1);
        StringBuilder stringBuilder = new StringBuilder();

        int i=0;
        while (i< chars.length){
            while (i<chars.length && chars[i]==' '){
                i++;
            }

            if(i==chars.length){
                break;
            }

            int l = i;
            while (i<chars.length && chars[i]!=' '){
                i++;
            }
            reverse(chars,l,i-1);

            for(int j = l;j<=i-1;j++){
                if(j==l && stringBuilder.length()!=0){
                    stringBuilder.append(' ');
                }
                stringBuilder.append(chars[j]);
            }
        }
        return stringBuilder.toString();
    }


    void reverse(char[] chars,int l,int r){
        while (l<r){
            char tmp = chars[r];
            chars[r] = chars[l];
            chars[l] = tmp;
            l++;
            r--;
        }
    }



    //双指针
    class Solution {
        public String reverseWords(String s) {
            s = s.trim();                                    // 删除首尾空格
            int j = s.length() - 1, i = j;
            StringBuilder res = new StringBuilder();
            while (i >= 0) {
                while (i >= 0 && s.charAt(i) != ' ') i--;     // 搜索首个空格
                res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
                while (i >= 0 && s.charAt(i) == ' ') i--;     // 跳过单词间空格
                j = i;                                       // j 指向下个单词的尾字符
            }
            return res.toString().trim();                    // 转化为字符串并返回
        }
    }

    @Test
    public void test(){
        reverseWords("the sky is blue");
    }
}
