package _008_Backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/permutations/
 */
public class Permute {

    int vis[] = new int[21];
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return ans;
    }

//0 1
    void dfs(int[] nums){
        //终止条件
        if(path.size()==nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if(vis[v+10]==1){
                continue;
            }

            path.add(v);
            vis[v+10] = 1;
            dfs(nums);
            path.remove(path.size()-1);
            vis[v+10] = 0;

        }
    }

    @Test
    public void test(){
        int[] arr = new int[]{0,1};

        permute(arr);
    }

}
