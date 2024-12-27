package _009_Greedy;

import java.util.Comparator;
import java.util.List;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-processing-time/
 */
public class MinProcessingTime {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        processorTime.sort(Comparator.comparingInt(a -> a));
        tasks.sort(Comparator.comparingInt(a -> a));
        int n = processorTime.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, processorTime.get(i) + tasks.get(4 * n - 1 - 4 * i));
        }
        return ans;
    }
}
