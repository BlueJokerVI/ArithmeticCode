package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-number-of-groups-entering-a-competition/
 */
public class MaximumGroups {
    public int maximumGroups(int[] grades) {
        int n = grades.length;

        int cur = 1;
        int ans = 0;
        while (n >= cur) {
            ans++;
            n -= cur;
            cur++;
        }
        return ans;
    }
}
