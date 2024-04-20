package _010_dp;

import _007_Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/house-robber-iii/
 */
public class Rob2 {
    public int rob(TreeNode root) {
        return dfs(root);
    }

    Map<TreeNode,Integer> mp = new HashMap<>();

    //记忆化搜索
    int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        if(mp.containsKey(root)){
            return mp.get(root);
        }

        //取当前节点
        int s1 = root.val;
        if(root.left!=null) {
            s1 += dfs(root.left.left);
        }
        if(root.left!=null) {
            s1 += dfs(root.left.right);
        }
        if(root.right!=null) {
            s1 += dfs(root.right.left);
        }
        if(root.right!=null) {
            s1 += dfs(root.right.right);
        }

        //不取当前节点
        int s2 = 0;
        s2 += dfs(root.left);
        s2 += dfs(root.right);

        int ans = Math.max(s1,s2);
        mp.put(root,ans);
        return ans;
    }


    // 3.后序遍历+数装dp
    // 执行用时：0 ms , 在所有 Java 提交中击败了 100% 的用户
    // 不偷：Max(左孩子不偷，左孩子偷) + Max(右孩子不偷，右孩子偷)
    // root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) +
    // Math.max(rob(root.right)[0], rob(root.right)[1])
    // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
    // root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
    public int rob3(TreeNode root) {
        int[] res = robAction1(root);
        return Math.max(res[0], res[1]);
    }

    int[] robAction1(TreeNode root) {
        int res[] = new int[2];
        if (root == null) {
            return res;
        }

        int[] left = robAction1(root.left);
        int[] right = robAction1(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
