package _008_Backtracking;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {

    List<String> ans = new ArrayList<>();
    StringBuffer cur = new StringBuffer();
    Map<Character,List<Character>> mp;

    public List<String> letterCombinations(String digits) {
        mp = new HashMap<>();
        mp.put('2', Arrays.asList('a','b','c'));
        mp.put('3', Arrays.asList('d','e','f'));
        mp.put('4', Arrays.asList('g','h','i'));
        mp.put('5', Arrays.asList('j','k','l'));
        mp.put('6', Arrays.asList('m','n','o'));
        mp.put('7', Arrays.asList('p','q','r','s'));
        mp.put('8', Arrays.asList('t','u','v'));
        mp.put('9', Arrays.asList('w','x','y','z'));

        dfs(0,digits);
        return ans;
    }

    void dfs(int index,String digits){
        if(index==digits.length()){
            if(cur.length()>0){
                ans.add(cur.toString());
            }
            return;
        }

        char c = digits.charAt(index);
        List<Character> characters = mp.get(c);

        for (Character character : characters) {
            cur.append(character);
            dfs(index+1,digits);
            cur.deleteCharAt(cur.length()-1);
        }

    }
}
