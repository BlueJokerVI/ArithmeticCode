package _008_Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/subsets-ii/
 */

public class SubsetsWithDup {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private Map<Integer,Integer> cnt =new HashMap<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //一定包含空集
        ans.add(path);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            Integer orDefault = cnt.getOrDefault(num, 0)+1;
            if(orDefault.equals(1)){
                list.add(num);
            }
            cnt.put(num,orDefault);
        }
        dfs(0, list);
        return ans;
    }

    //纵深横广
    void dfs(int index, List<Integer> nums) {
        if (index >= nums.size()) {
            return;
        }

        for (int i = index; i < nums.size(); i++) {
            int v = nums.get(i);
            if(cnt.get(v).equals(1)){
                path.add(v);
                ans.add(new ArrayList<>(path));
                dfs(i + 1, nums);
                path.remove(path.size() - 1);
            }else {
                cnt.put(v,cnt.get(v)-1);
                path.add(v);
                ans.add(new ArrayList<>(path));
                dfs(i, nums);
                path.remove(path.size() - 1);
                cnt.put(v,cnt.get(v)+1);
            }

        }
    }
}
