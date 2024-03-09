package _003_Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-08  23:03
 * @Description: https://leetcode.cn/problems/valid-anagram/
 * 242. 有效的字母异位词
 * @Version: 1.0
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        Map<Character,Integer> mp1 = new HashMap<>();
        Map<Character,Integer> mp2 = new HashMap<>();

        for(int i=0;i<s.length();i++){
            mp1.put(s.charAt(i),mp1.getOrDefault(s.charAt(i),0)+1);
        }


        for(int i=0;i<t.length();i++){
            mp2.put(t.charAt(i),mp2.getOrDefault(t.charAt(i),0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(!mp1.get(s.charAt(i)).equals(mp2.get(s.charAt(i)))){
                return false;
            }
        }

        return true;
    }
}
