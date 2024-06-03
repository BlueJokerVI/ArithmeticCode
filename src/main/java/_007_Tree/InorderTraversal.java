package _007_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2024-03-06  09:05
 * @Description: TODO
 * @Version: 1.0
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        getPre(ans,root);

        return ans;
    }

    void getPre(List<Integer> ans, TreeNode root){
        if (root == null){
            return;
        }

        getPre(ans,root.left);
        ans.add(root.val);
        getPre(ans,root.right);

    }

    //迭代法中序遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> s = new ArrayDeque<>();

        while (root!=null || !s.isEmpty()){
            while (root!=null){
                s.push(root);
                root = root.left;
            }

            TreeNode poll = s.poll();
            ans.add(poll.val);

            root = poll.right;
        }

        return ans;
    }


}
