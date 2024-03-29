package _008_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/permutations-ii/
 * 排列问题，输入数组有重复
 */
public class PermuteUnique {

    int vis[] = new int[21];
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        for (int num : nums) {
            vis[num+10]++;
        }

        dfs(nums);
        return ans;
    }

    //0 1
    void dfs(int[] nums) {
        //终止条件
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        int used[] = new int[21];
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];

            if (vis[v + 10] == 0) {
                continue;
            }

            //同层值一样的节点只能用一一
            if(used[v+10]==1){
                continue;
            }

            used[v+10] = 1;
            path.add(v);
            vis[v + 10]--;
            dfs(nums);
            path.remove(path.size() - 1);
            vis[v + 10]++;

        }
    }
}
