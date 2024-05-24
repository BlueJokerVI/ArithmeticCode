package _003_Hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            cnt[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            cnt[ransomNote.charAt(i) - 'a']--;
            if (cnt[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            cnt[t.charAt(i) - 'a']--;
            if (cnt[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Set<Map<Character, Integer>> set = new HashSet<>();
        Map<Map<Character, Integer>, List<String>> ans = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> tmp = new HashMap<>();
            for (int j = 0; j < str.length(); j++) {
                tmp.put(str.charAt(j), tmp.getOrDefault(str.charAt(j), 0) + 1);
            }
            boolean contains = set.contains(tmp);
            if (!contains) {
                set.add(tmp);
                ArrayList<String> strings = new ArrayList<>();
                strings.add(str);
                ans.put(tmp, strings);
            } else {
                List<String> strings = ans.get(tmp);
                strings.add(str);
            }
        }
        return new ArrayList<List<String>>(ans.values());
    }

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            for (String str : strs) {
                int[] counts = new int[26];
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    counts[str.charAt(i) - 'a']++;
                }
                // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < 26; i++) {
                    if (counts[i] != 0) {
                        sb.append((char) ('a' + i));
                        sb.append(counts[i]);
                    }
                }
                String key = sb.toString();
                List<String> list = map.getOrDefault(key, new ArrayList<String>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<List<String>>(map.values());
        }
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        Map<Integer, Integer> moreMp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                moreMp.put(nums[i], i);
            } else {
                mp.put(nums[i], i);
            }

        }
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] < target) {
                l++;
            } else if (nums[l] + nums[r] > target) {
                r--;
            } else {
                if (nums[r] == nums[l]) {
                    return new int[]{mp.get(nums[l]), moreMp.get(nums[r])};
                }
                return new int[]{mp.get(nums[l]), mp.get(nums[r])};
            }
        }
        //不会执行到这
        return new int[]{};
    }


    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {
            int sum = 0;
            int v = n % 10;
            int m = n / 10;
            while (v > 0 || m > 0) {
                sum += v * v;
                v = m % 10;
                m /= 10;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);

            n =  sum;
        }
        return true;
    }


    @org.junit.Test
    public void test() {
        twoSum(new int[]{3, 3}, 6);
    }
}
