package _009_Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-split-of-positive-even-integers/
 */
public class MaximumEvenSplit {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if(finalSum % 2==1){
            return ans;
        }
        long index = 1;
        while (finalSum > 0) {
            long cur = 2 * index;
            if (finalSum > cur) {
                ans.add(cur);
                finalSum -= cur;
                index++;
            } else {
                Long v = ans.remove(ans.size() - 1) + finalSum;
                ans.add(v);
                finalSum = 0;
            }
        }
        return ans;
    }
}
