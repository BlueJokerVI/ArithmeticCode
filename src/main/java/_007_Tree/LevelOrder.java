package _007_Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2024-03-06  09:19
 * @Description: https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
 * 分层的返会树节点，先序遍历维护深度h
 * @Version: 1.0
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        getLevel(root,0,ans);
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


    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            //使queue每次进while循环都是保存同一层节点
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }


}
