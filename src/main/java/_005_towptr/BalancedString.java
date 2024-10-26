package _005_towptr;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
 */
public class BalancedString {
    public int balancedString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int min = Integer.MAX_VALUE;
        int l = 0;
        Map<Character, Integer> mp = new HashMap<>();
        int q = 0, w = 0, e = 0, r = 0;
        for (char c : cs) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        int k = n / 4;
        mp.replaceAll((key, v) -> v - k);
        if (mp.containsKey('Q') && mp.get('Q') <= 0) {
            mp.remove('Q');
        }
        if (mp.containsKey('W') && mp.get('W') <= 0) {
            mp.remove('W');
        }
        if (mp.containsKey('E') && mp.get('E') <= 0) {
            mp.remove('E');
        }
        if (mp.containsKey('R') && mp.get('R') <= 0) {
            mp.remove('R');
        }


        int zn = mp.size();
        if(zn==0){
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (!mp.containsKey(cs[i])) {
                continue;
            }
            mp.put(cs[i], mp.get(cs[i]) - 1);
            if (mp.get(cs[i]) == 0) {
                zn--;
            }

            while (zn == 0) {
                if (i - l + 1 < min) {
                    min = i - l + 1;
                }

                if (mp.containsKey(cs[l])) {
                    mp.put(cs[l], mp.get(cs[l]) + 1);

                    if (mp.get(cs[l]) == 1) {
                        zn++;
                    }
                }

                l++;

            }
        }

        return  min;

    }


    public static void main(String[] args) {

        Map<Character, Integer> mp = new HashMap<>();
        mp.put('Q', 1);
        mp.put('w', 1);
        mp.put('e', 1);
        mp.put('r', 1);

        System.out.println(mp.size());
        if (mp.get('Q') == 1) {
            mp.remove('Q');
        }
        System.out.println(mp.size());
    }
}
