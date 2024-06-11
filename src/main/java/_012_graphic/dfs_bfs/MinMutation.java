package _012_graphic.dfs_bfs;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-genetic-mutation/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinMutation {

    int ans = Integer.MAX_VALUE;
    boolean[] vis = new boolean[11];

    public int minMutation(String startGene, String endGene, String[] bank) {
        dfs(startGene, 0, endGene, bank);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    void dfs(String cur, int step, String endGene, String[] bank) {
        //快速返回
        if (step >= ans) {
            return;
        }
        if (cur.equals(endGene)) {
            ans = step;
            return;
        }

        //遍历每次可能突变成的值
        for (int i = 0; i < bank.length; i++) {
            if (vis[i]) {
                continue;
            }

            String s = bank[i];
            int cnt = 0;
            for (int j = 0; j < 8; j++) {
                if (s.charAt(j) != cur.charAt(j)) {
                    cnt++;
                }
            }

            if (cnt == 1) {
                vis[i] = true;
                dfs(bank[i], step + 1, endGene, bank);
                vis[i] = false;
            }
        }
    }



    //bfs解法
    static char[] items = new char[]{'A', 'C', 'G', 'T'};
    public int minMutationBFS(String S, String T, String[] bank) {
        Set<String> set = new HashSet<>();
        for (String s : bank) set.add(s);
        Deque<String> d = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        d.addLast(S);
        map.put(S, 0);
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                String s = d.pollFirst();
                char[] cs = s.toCharArray();
                int step = map.get(s);
                for (int i = 0; i < 8; i++) {
                    for (char c : items) {
                        if (cs[i] == c) continue;
                        char[] clone = cs.clone();
                        clone[i] = c;
                        String sub = String.valueOf(clone);
                        if (!set.contains(sub)) continue;
                        if (map.containsKey(sub)) continue;
                        if (sub.equals(T)) return step + 1;
                        map.put(sub, step + 1);
                        d.addLast(sub);
                    }
                }
            }
        }
        return -1;
    }


    @Test
    public void test() {
        minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"});
    }
}
