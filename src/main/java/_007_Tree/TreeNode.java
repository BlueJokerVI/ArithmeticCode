package _007_Tree;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2024-03-06  08:55
 * @Description: 树节点
 * @Version: 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
