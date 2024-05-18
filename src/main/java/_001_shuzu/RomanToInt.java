package _001_shuzu;

import java.util.HashMap;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/studyplan/top-interview-150/
 */
public class RomanToInt {
    public int romanToInt(String s) {
        HashMap<String, Integer> mp = new HashMap<>();
        mp.put("I",1);
        mp.put("V",5);
        mp.put("X",10);
        mp.put("L",50);
        mp.put("C",100);
        mp.put("D",500);
        mp.put("M",1000);
        mp.put("IV",4);
        mp.put("IX",9);
        mp.put("XL",40);
        mp.put("XC",90);
        mp.put("CD",400);
        mp.put("CM",900);

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i<s.length()-1){
                String substring = s.substring(i, i + 2);
                if (mp.containsKey(substring)) {
                    ans+=mp.get(substring);
                    i++;
                    continue;
                }
            }
            String substring = s.substring(i, i + 1);
            ans+=mp.get(substring);
        }
        return ans;
    }

}
