package _013_binary_search;

import java.util.*;

/**
 * @author cct
 * https://leetcode.cn/problems/find-longest-special-substring-that-occurs-thrice-ii/
 */
public class MaximumLength {
    public int maximumLength(String s) {
        int n = s.length();
        int l = 1, r = n - 2;

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(s, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1 >= 1 ? l - 1 : -1;
    }

    boolean check(String s, int mid) {
        Map<String, Integer> cnt = new HashMap<>();
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] vis = new int[26];
        int dif = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            int idx = cs[r] - 'a';
            vis[idx]++;
            if (vis[idx] == 1) {
                dif++;
            }

            if (r >= mid) {
                vis[cs[l] - 'a']--;
                if (vis[cs[l] - 'a'] == 0) {
                    dif--;
                }
                l++;
            }


            if (r >= mid - 1 && dif == 1) {
                String sub = s.substring(r - mid + 1, r + 1);
                cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
                if (cnt.get(sub) >= 3) {
                    return true;
                }
            }
        }
        return false;
    }


    //分类讨论法
    public int maximumLength1(String S) {
        char[] s = S.toCharArray();
        List<Integer>[] groups = new ArrayList[26];
        Arrays.setAll(groups, i -> new ArrayList<>());
        int cnt = 0;
        for (int i = 0; i < s.length; i++) {
            cnt++;
            if (i + 1 == s.length || s[i] != s[i + 1]) {
                groups[s[i] - 'a'].add(cnt); // 统计连续字符长度
                cnt = 0;
            }
        }

        int ans = 0;
        for (List<Integer> a : groups) {
            if (a.isEmpty()) continue;
            a.sort(Collections.reverseOrder());
            a.add(0);
            a.add(0); // 假设还有两个空串
            ans = Math.max(ans, Math.max(a.get(0) - 2, Math.max(Math.min(a.get(0) - 1, a.get(1)), a.get(2))));
        }

        return ans > 0 ? ans : -1;
    }


    public static void main(String[] args) {
        MaximumLength t = new MaximumLength();
        t.maximumLength("ereerrrererrrererre");
    }
}
