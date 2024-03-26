package _008_Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/combination-sum/
 */
public class CombinationSum {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int cur = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0,candidates,target);
        return ans;
    }

    void dfs(int start, int[] candidates, int target){
        if(cur>=target){
            if(cur==target){
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            cur +=candidate;
            path.add(candidate);
            //注意i的改变，保证递归每次添加的元素位置大于等于当前使用元素的位置
            dfs(i,candidates,target);
            cur -= candidate;
            path.remove(path.size()-1);
        }


    }

}
