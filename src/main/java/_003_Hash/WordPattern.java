package _003_Hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {

        Map<Character, String> cs = new HashMap<>();
        Map<String, Character> sc = new HashMap<>();
        String[] strings = s.split(" ");

        if(strings.length!=pattern.length()){
            return false;
        }


        for (int i = 0; i < pattern.length(); i++) {
            if (cs.containsKey(pattern.charAt(i)) && !cs.get(pattern.charAt(i)).equals(strings[i])) {
                return false;
            }
            if (sc.containsKey(strings[i]) && sc.get(strings[i]) != pattern.charAt(i)) {
                return false;
            }
            cs.put(pattern.charAt(i), strings[i]);
            sc.put(strings[i], pattern.charAt(i));
        }
        return true;

    }

    @Test
    public void test(){
       wordPattern("abba","dog cat cat dog");
    }

}
