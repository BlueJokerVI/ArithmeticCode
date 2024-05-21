package _005_towptr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/substring-with-concatenation-of-all-words/?envType=study-plan-v2&envId=top-interview-150
 */
public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> cnt = new HashMap<>();
        Map<String, Integer> tmpCnt = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int len = words[0].length();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < s.length() - len + 1; i++) {
            String substring = s.substring(i, i + words.length * len);
            String[] strings = splitStringByLength(substring, len);
            tmpCnt.clear();

            boolean f = false;
            for (String word : strings) {
                if (!cnt.containsKey(word)) {
                    f = true;
                    break;
                }
                tmpCnt.put(word, tmpCnt.getOrDefault(word, 0) + 1);
            }
            if (f || tmpCnt.size() != cnt.size()) {
                continue;
            }
            f = false;
            for (String word : words) {
                if (!cnt.get(word).equals(tmpCnt.get(word))) {
                    f = true;
                }
            }
            if (!f) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static String[] splitStringByLength(String str, int length) {
        // 计算结果数组的大小
        int size = (int) Math.ceil((double) str.length() / length);
        String[] result = new String[size];

        for (int i = 0; i < size; i++) {
            int start = i * length;
            int end = Math.min(start + length, str.length());
            result[i] = str.substring(start, end);
        }
        return result;
    }


    //滑动窗口分组  666
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
            HashMap<String, Integer> map = new HashMap<>();
            int one_word = words[0].length();
            int word_num = words.length;
            int all_len = one_word * word_num;
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            for (int i = 0; i < one_word; i++) {
                //s中[left,right) 字串    count: 字串中word的数量
                int left = i, right = i, count = 0;
                HashMap<String, Integer> tmp_map = new HashMap<>();
                while (right + one_word <= s.length()) {
                    String w = s.substring(right, right + one_word);
                    tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                    right += one_word;
                    count++;

                    //诺加入的这个word数量多了，就移动left直到[left,right)内word数量不在多
                    while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                        String t_w = s.substring(left, left + one_word);
                        count--;
                        tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                        left += one_word;
                    }
                    if (count == word_num) res.add(left);
                }
            }
            return res;
        }
    }
}
