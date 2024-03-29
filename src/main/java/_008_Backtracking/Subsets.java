package _008_Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/subsets/solutions/420294/zi-ji-by-leetcode-solution/
 */

public class Subsets {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        //一定包含空集
        ans.add(path);
        dfs(0, nums);
        return ans;
    }

    //纵深横广
    void dfs(int index, int[] nums) {
        if (index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int v = nums[i];
            path.add(v);
            ans.add(new ArrayList<>(path));
            dfs(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}
