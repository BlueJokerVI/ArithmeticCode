package _008_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/combinations/
 */
public class Combine {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> cur = new ArrayList<>();
        dfs(1,n,k,cur);
        return ans;
    }

    void dfs(int start,int n,int k ,List<Integer> cur){
        if(k==cur.size()){
            List<Integer> tmp = new ArrayList<>(cur);
            ans.add(tmp);
            return;
        }

        //  减枝优化  还要寻找的元素个数：k - cur.size()               1    k    n - (k - cur.size()) + 1

        for (int i = start; i <=  n - (k - cur.size() ) + 1 ; i++) {
            cur.add(i);
            dfs(i+1,n,k,cur);

            //回溯
            cur.remove(cur.size()-1);
        }
    }
}
