package _007_Tree;

import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&envId=top-interview-150
 */
public class MaxPathSum {

    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getAns(root);
        return ans;
    }

    private int getAns(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = getAns(root.left);
        int r = getAns(root.right);

        int cur = root.val;
        if(l>0){
            cur+=l;
        }
        if(r>0){
            cur+=r;
        }

        if(cur > ans){
            ans = cur;
        }

        cur = root.val;
        cur += Math.max(0,Math.max(l,r));

        return cur;
    }
}
