package _007_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/binary-search-tree-iterator/?envType=study-plan-v2&envId=top-interview-150
 */
public class BSTIterator {

    private Deque<TreeNode> s = new ArrayDeque<>();

    void dfsLeft(TreeNode node){
        while (node!=null){
            s.push(node);
            node = node.left;
        }
    }

    public BSTIterator(TreeNode root) {
        dfsLeft(root);
    }

    public int next() {
        TreeNode pop = s.pop();
        dfsLeft(pop.right);
        return pop.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }
}
