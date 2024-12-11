package _013_binary_search;

import _007_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cct
 * https://leetcode.cn/problems/closest-nodes-queries-in-a-binary-search-tree/
 */
public class ClosestNodes {

    List<Integer> order = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root);
        for (int v : queries) {
            int l = 0, r = order.size() - 1;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (order.get(mid) < v) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            List<Integer> tmp = new ArrayList<>();
            int lv = l - 1 >= 0 ? order.get(l - 1) : -1;
            int rv = l < order.size() ? order.get(l) : -1;

            if (rv == v) {
                tmp.add(v);
                tmp.add(v);
            } else {
                tmp.add(lv);
                tmp.add(rv);
            }

            ans.add(tmp);
        }


        return ans;
    }

    void dfs(TreeNode node) {

        if (node == null) {
            return;
        }
        dfs(node.left);
        order.add(node.val);
        dfs(node.right);
    }

}
