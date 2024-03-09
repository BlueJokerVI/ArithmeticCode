package _004_Str;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-17  21:21
 * @Description: https://leetcode.cn/problems/reverse-words-in-a-string/
 * 151. 反转字符串中的单词
 * @Version: 1.0
 */
public class ReverseWords {
    public String reverseWords(String s) {

        /**
         * 从后往前遍历，截取每个单词放入集合，最后将集合转为String输出
         */

        //记录每个单词后的空格下标,方便截取单词
        int l;

        List<String> st = new ArrayList<>();
        int i=s.length()-1;

        while (s.charAt(i)==' '){
            i--;
        }

        l = i+1;
        for (; i >= 0; i--) {
            char c = s.charAt(i);
            if(c==' '){
                st.add(s.substring(i+1,l));

                while (s.charAt(i)==' '){
                    i--;
                    if(i<0){
                        return listToStr(st);
                    }
                }
                l=i+1;
                i++;
            }else if(i==0){
                st.add(s.substring(0,l));
                return listToStr(st);
            }
        }
        return listToStr(st);
    }


    public String listToStr(List<String> st){

        StringBuffer ans = new StringBuffer();

        for (int i = 0; i <st.size() ; i++) {
            if(i!=st.size()-1){
                ans.append(st.get(i)+' ');
            }else{
                ans.append(st.get(i));
            }
        }
        return ans.toString();
    }


    @Test
    public void test(){
        this.reverseWords("the sky is blue");
//        System.out.println("the sky is blue".length());
//        char c = ' ';
//        System.out.println(c==' ');
    }

}
