package _009_Greedy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author cct
 * https://leetcode.cn/problems/reduce-array-size-to-the-half/
 */
public class MinSetSize {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : arr) {
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> collect = mp.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).collect(Collectors.toList());
        int cur = 0;
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : collect) {
            cnt++;
            cur += entry.getValue();
            if (cur >= (n + 1) / 2) {
                break;
            }
        }
        return cnt;
    }
}
