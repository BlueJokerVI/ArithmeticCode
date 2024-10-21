package _005_towptr;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-number-of-occurrences-of-a-substring/
 */
public class MaxFreq {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        char[] arr = s.toCharArray();

        int maxCnt = 0;
        int diff = 0;

        Map<String, Integer> mp = new HashMap<>();

        //计算窗口长度位minSize就行，长串重复，字串一定也重复
        int l = 0;
        int[] vis = new int[26];
        for (int r = 0; r < n; r++) {
            int index = arr[r] - 'a';
            vis[index]++;
            if (vis[index] == 1) {
                diff++;
            }
            if (r - l + 1 == minSize) {
                if (diff <= maxLetters) {
                    String key = s.substring(l, r + 1);
                    mp.put(key, mp.getOrDefault(key, 0) + 1);
                    int cnt = mp.get(key);
                    if (cnt > maxCnt) {
                        maxCnt = cnt;
                    }
                }
                index = arr[l] - 'a';
                vis[index]--;
                if (vis[index] == 0) {
                    diff--;
                }
                l++;
            }
        }

        return maxCnt;
    }

    public static void main(String[] args) {
        MaxFreq maxFreq = new MaxFreq();
        maxFreq.maxFreq("abcabababacabcabc", 3, 3, 10);

    }
}
