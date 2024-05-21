package _005_towptr;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-interview-150
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() <= 1) {
            return s.length();
        }

        //key c  value  c_index
        Map<Character, Integer> mp = new HashMap<>();

        int l = 0, r = 0;
        int len = Integer.MIN_VALUE;
        while (l <= r && r<s.length()) {
           boolean contain = mp.containsKey(s.charAt(r));
           if(!contain){
               mp.put(s.charAt(r),r);
               if(mp.size() > len){
                   len = mp.size();
               }
           }else {
               int preIndex = mp.get(s.charAt(r));
               //移除[l,preIndex]元素
               while (l<=preIndex){
                   mp.remove(s.charAt(l));
                   l++;
               }
               mp.put(s.charAt(r),r);
               if(mp.size() > len){
                   len = mp.size();
               }
           }
            r++;
        }
        return len;
    }

    @Test
    public void test(){
        lengthOfLongestSubstring("pwwkew");
    }
}

