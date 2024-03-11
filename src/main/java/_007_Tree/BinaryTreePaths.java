package _007_Tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

    private List<Integer> cur  = new ArrayList<>();
    private List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {

        dfs(root);

        return ans;
    }

    void dfs(TreeNode root){
        cur.add(root.val);

        if(root.left!=null) {
            dfs(root.left);
        }

        if(root.right!=null){
            dfs(root.right);
        }


        if(root.left==null && root.right==null){

            String collect = cur.stream().map(integer -> integer.toString()).collect(Collectors.joining("->"));
            ans.add(collect);

        }
        cur.remove(cur.size()-1);
    }
}
