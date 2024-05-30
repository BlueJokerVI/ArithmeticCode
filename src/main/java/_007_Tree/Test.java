package _007_Tree;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */


public class Test {


    public int maxDepth(TreeNode root) {
        return dfs(root);
    }


    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = 1 + dfs(node.left);
        int r = 1 + dfs(node.right);

        return Math.max(l, r);
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }

        if (p != null && q == null) {
            return false;
        }

        if (p == null) {
            return true;
        }

        if (q.val != p.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


}
