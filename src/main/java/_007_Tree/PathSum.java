package _007_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/path-sum-ii/
 */
public class PathSum {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> curPath = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,0);
        return ans;
    }

    void dfs(TreeNode node,int target,int pre){
        if(node==null){
            return ;
        }
        curPath.add(node.val);
        int cur = pre + node.val;
        if(node.left==null && node.right==null && target == cur){
            List<Integer> one = new ArrayList<>(curPath);
            ans.add(one);
            curPath.remove(curPath.size()-1);
            return;
        }

        dfs(node.left,target,cur);
        dfs(node.right,target,cur);
        curPath.remove(curPath.size()-1);
    }
}
