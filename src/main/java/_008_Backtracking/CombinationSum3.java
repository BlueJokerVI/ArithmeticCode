package _008_Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/combination-sum-iii/
 */
public class CombinationSum3 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int cur = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1,k,n);
        return ans;
    }
    
    void  dfs(int start,int k,int sum){
        if(k==path.size()){
            if(cur == sum){
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        for(int i=start;i<=9 -(k-path.size())+1;i++){

            if(cur+i>sum){
                continue;
            }

            path.add(i);
            cur+=i;
            dfs(i+1,k,sum);
            path.remove(path.size()-1);
            cur-=i;
        }
    }
}
