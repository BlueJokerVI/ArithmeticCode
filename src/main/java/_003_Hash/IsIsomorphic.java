package _003_Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/isomorphic-strings/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mpst = new HashMap<>();
        Map<Character, Character> mpts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (mpts.containsKey(t.charAt(i)) && mpts.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
            if (mpst.containsKey(s.charAt(i)) && mpst.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            mpts.put(t.charAt(i), s.charAt(i));
            mpst.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }

}
