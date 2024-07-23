package _007_Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/path-sum-iii/?envType=study-plan-v2&envId=top-100-liked
 */
public class PathSum3 {

    Map<Long,Integer> prefixSum = new HashMap<>();

    public int pathSum(TreeNode root, long targetSum) {
        prefixSum.put(0L,1);
        return count(root,targetSum,0);
    }


    private int count(TreeNode root,long targetSum,long cur){
        if(root==null){
            return 0;
        }

        int ans = 0;
        cur = cur + root.val;

        ans += prefixSum.getOrDefault(cur-targetSum,0);
        prefixSum.put(cur,prefixSum.getOrDefault(cur,0)+1);

        ans += count(root.left,targetSum,cur);
        ans += count(root.right,targetSum,cur);
        prefixSum.put(cur,prefixSum.getOrDefault(cur,0)-1);
        return ans;
    }
}
