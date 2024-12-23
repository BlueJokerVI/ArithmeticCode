package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/
 */
public class MinimumBuckets {
    public int minimumBuckets(String hamsters) {

        hamsters = "a" + hamsters + "a";

        char[] cs = hamsters.toCharArray();
        int ans = 0;
        int n = cs.length;
        for (int i = 1; i < n - 1; i++) {
            if (cs[i] == 'H') {
                if (cs[i - 1] == 'x' || cs[i + 1] == 'x') {
                    continue;
                }

                if (cs[i - 1] != '.' && cs[i + 1] != '.') {
                    return -1;
                }

                if (cs[i + 1] == '.') {
                    cs[i + 1] = 'x';
                }
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumBuckets t = new MinimumBuckets();
        t.minimumBuckets(".HH.H.H.H..");
    }
}
