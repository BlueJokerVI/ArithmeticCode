package _008_Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test {

    boolean[] vis = new boolean[21];
    int[] nums;
    List<Integer> cur = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int remainder;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        nums = candidates;
        remainder = target;
        dfs(0);
        return ans;
    }

    void dfs(int index) {
        for (int i = index; i < nums.length; i++) {
            if (remainder >= nums[i]) {
                cur.add(nums[i]);
                remainder -= nums[i];
                if(remainder==0){
                    ans.add(new ArrayList<>(cur));
                }else {
                    dfs(i);
                }
                remainder += nums[i];
                cur.remove(cur.size() - 1);
            }
        }
    }

    @org.junit.Test
    public void test() {
        combinationSum(new int[]{2,3,6,7},7);
    }
}
