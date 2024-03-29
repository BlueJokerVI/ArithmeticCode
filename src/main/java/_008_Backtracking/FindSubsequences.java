package _008_Backtracking;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/non-decreasing-subsequences/
 */
public class FindSubsequences {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Map<Integer,Integer> mp = new HashMap<>();

    List<List<Integer>> reBuildList = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        dfs(0,nums);
        return ans;
    }

    // 1 10 1 1 1
    void dfs(int index,int[] nums){
        if(index>=nums.length){
            return;
        }

        //控制同一层每个变量只能访问一次
        int vis[] = new int[210];
        Arrays.fill(vis,0);

        for(int i=index;i<nums.length;i++){

            int v = nums[i];
            //序列要递增
            if(path.size()>0 && path.get(path.size()-1) > v){
                continue;
            }

            //同层使用的节点不能相同
            if(vis[v]==1){
                continue;
            }

            path.add(v);
            if(path.size()>=2){
                ans.add(new ArrayList<>(path));
            }
            vis[v] = 1;
            dfs(i+1,nums);
            path.remove(path.size()-1);
        }
    }


    @Test
    public void test(){
        int[] arr = new int[]{1,10,1,1};
        findSubsequences(arr);
    }
}
