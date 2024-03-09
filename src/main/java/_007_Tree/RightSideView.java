package _007_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2024-03-07  09:10
 * @Description: https://leetcode.cn/problems/binary-tree-right-side-view/
 * @Version: 1.0
 */
public class RightSideView {

    //普通层序遍历
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root==null){
            return ans;
        }
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.left!=null) {
                    queue.offer(poll.left);
                }
                if(poll.right!=null) {
                    queue.offer(poll.right);
                }
                if(i==size-1){
                    ans.add(poll.val);
                }
            }

        }

        return ans;
    }

    //dfs法
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0,ans);
        return ans;
    }

    private void dfs(TreeNode root, int depth,List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (depth == ans.size()) {
            ans.add(root.val);
        }
        dfs(root.right, depth + 1,ans);
        dfs(root.left, depth + 1,ans);
    }


}
