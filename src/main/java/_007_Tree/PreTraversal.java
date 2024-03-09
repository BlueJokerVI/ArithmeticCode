package _007_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2024-03-06  08:54
 * @Description: 先序遍历
 * @Version: 1.0
 */
public class PreTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        getPre(ans,root);

        return ans;
    }

    void getPre(List<Integer> ans, TreeNode root){
        if (root == null){
            return;
        }
        ans.add(root.val);
        getPre(ans,root.left);
        getPre(ans,root.right);
    }

}
