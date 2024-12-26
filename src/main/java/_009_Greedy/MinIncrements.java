package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/make-costs-of-paths-equal-in-a-binary-tree/
 */
public class MinIncrements {

    int ans = 0;

    public int minIncrements(int n, int[] cost) {
        dfs(n, cost, 1);
        return ans;
    }

    int dfs(int n, int[] cost, int cur) {
        if (cur > n) {
            return 0;
        }
        int l = dfs(n, cost, 2 * cur);
        int r = dfs(n, cost, 2 * cur + 1);
        ans += Math.abs(l - r);
        return Math.max(l, r) + cost[cur - 1];
    }


    //满二叉树数组写法
    public int minIncrements1(int n, int[] cost) {
        int ans = 0;
        //第一个非叶子节点开始遍历
        for (int i = n / 2; i > 0; i--) {
            ans += Math.abs(cost[2 * i] - cost[2 * i + 1]);
            cost[i - 1] += Math.max(cost[2 * i], 2 * i + 1);
        }
        return ans;
    }

}
