package _007_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2024-03-07  08:51
 * @Description: TODO
 * @Version: 1.0
 */
class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        getLevel(root,0,ans);
        Collections.reverse(ans);
        return ans;
    }

    void getLevel(TreeNode root,int h,List<List<Integer>> ans){
        if(root==null){
            return;
        }
        int size = ans.size();
        if(size>h){
            ans.get(h).add(root.val);
        }else {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(root.val);
            ans.add(integers);
        }
        getLevel(root.left,h+1,ans);
        getLevel(root.right,h+1,ans);
    }
}
