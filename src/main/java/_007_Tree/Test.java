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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int pl,int pr,int[] inorder,int il,int ir){
        if(pl > pr){
            return null;
        }
        TreeNode cur = new TreeNode();
        cur.val = preorder[pl];
        int index = il;
        while (cur.val!=inorder[index]){
            index++;
        }
        //左子树元素个数
        int lenL = index - il;
        int lenR = ir - index;
        cur.left = buildTree(preorder, pl+1, pl+lenL, inorder, il, index-1);
        cur.right = buildTree(preorder, pl+lenL+1, pr, inorder, index+1, ir);
        return cur;
    }


    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        return buildTreeWithI_P(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode buildTreeWithI_P(int[] inorder,int il,int ir ,int[] postorder,int pl,int pr){
        if(il > ir){
            return null;
        }
        TreeNode cur = new TreeNode();
        cur.val = postorder[pr];
        int index = il;
        while (cur.val!=inorder[index]){
            index++;
        }
        //左子树元素个数
        int lenL = index - il;

        cur.left = buildTreeWithI_P(inorder,il,index-1,postorder,pl,pl+lenL-1);
        cur.right = buildTreeWithI_P(inorder,index+1,ir,postorder,pl+lenL,pr-1);
        return cur;
    }

}
