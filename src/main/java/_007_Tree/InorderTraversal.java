package _007_Tree;

import java.util.ArrayList;
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
}
