package _003_Hash;

import java.util.*;

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

            n = sum;
        }
        return true;
    }

    private int find(int[] nums, int v, int l, int r) {
        if (l > r) {
            return -1;
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < v) {
                l = mid + 1;
            } else if (nums[mid] > v) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public int longestConsecutive(int[] nums) {

        // key : 数组内的某一个值
        // value : 以该值所在连续序列最大长度
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (mp.containsKey(v)) {
                continue;
            }
            // 5 4  3 2 1     3    r-l + 1 = len   l = len  - r + 1
            int len;
            if (mp.containsKey(v - 1) && mp.containsKey(v + 1)) {
                len = mp.get(v - 1);
                //最左的元素值
                int l = v-len;
                len = mp.get(v + 1);
                //最右边元素值
                int r = len + v;
                //新的最大长度
                len = r - l + 1;
                //更新序列两端的最大值,每次更新只会在序列的两端
                mp.put(l, len);
                mp.put(r, len);
                mp.put(v,len);
            } else if (mp.containsKey(v - 1)) {
                len = mp.get(v - 1);
                //最左的元素值   v-1 - l + 1 = len   l = v-1+1 -len
                int l = v-len;
                len = v - l + 1;
                mp.put(l, len);
                mp.put(v,len);
            } else if(mp.containsKey(v + 1)){
                len = mp.get(v + 1);
                //最右边元素值
                int r = len + v;
                len = r - v + 1;
                mp.put(r, len);
                mp.put(v,len);
            }else {
                len = 1;
                mp.put(v,len);
            }
            if (len > ans) {
                ans = len;
            }
        }
        return ans;
    }





    @org.junit.Test
    public void test() {
        longestConsecutive(new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3});
    }
}
