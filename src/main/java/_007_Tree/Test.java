package _007_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

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
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        TreeNode cur = new TreeNode();
        cur.val = preorder[pl];
        int index = il;
        while (cur.val != inorder[index]) {
            index++;
        }
        //左子树元素个数
        int lenL = index - il;
        int lenR = ir - index;
        cur.left = buildTree(preorder, pl + 1, pl + lenL, inorder, il, index - 1);
        cur.right = buildTree(preorder, pl + lenL + 1, pr, inorder, index + 1, ir);
        return cur;
    }


    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        return buildTreeWithI_P(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeWithI_P(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
        if (il > ir) {
            return null;
        }
        TreeNode cur = new TreeNode();
        cur.val = postorder[pr];
        int index = il;
        while (cur.val != inorder[index]) {
            index++;
        }
        //左子树元素个数
        int lenL = index - il;

        cur.left = buildTreeWithI_P(inorder, il, index - 1, postorder, pl, pl + lenL - 1);
        cur.right = buildTreeWithI_P(inorder, index + 1, ir, postorder, pl + lenL, pr - 1);
        return cur;
    }

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Node cur = root;
        Node pre = null;
        Deque<Node> q = new ArrayDeque<>();
        q.push(cur);

        while (!q.isEmpty()) {
            int levelTime = q.size();
            pre = null;
            for (int i = 0; i < levelTime; i++) {
                cur = q.poll();
                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;
                if (i == q.size() - 1) {
                    cur.next = null;
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }

        return root;
    }

    //拼接链表写法
    public Node connect1(Node root) {
        Node dummy = new Node();
        Node cur = root;
        while (cur != null) {
            dummy.next = null;
            Node nxt = dummy; // 下一层的链表
            while (cur != null) { // 遍历当前层的链表
                if (cur.left != null) {
                    nxt.next = cur.left; // 下一层的相邻节点连起来
                    nxt = cur.left;
                }
                if (cur.right != null) {
                    nxt.next = cur.right; // 下一层的相邻节点连起来
                    nxt = cur.right;
                }
                cur = cur.next; // 当前层链表的下一个节点
            }
            cur = dummy.next; // 下一层链表的头节点
        }
        return root;
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (targetSum == 0 && root == null) {
            return false;
        }
        return getSum(root, 0, targetSum);
    }

    private boolean getSum(TreeNode treeNode, int sum, int target) {
        sum += treeNode.val;

        if (treeNode.left == null && treeNode.right == null) {
            return sum == target;
        }
        boolean l = false;
        boolean r = false;
        if (treeNode.left != null) {
            l = getSum(treeNode.left, sum, target);
        }
        if (treeNode.right != null) {
            r = getSum(treeNode.right, sum, target);
        }
        return l || r;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }

    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }


    TreeNode ans = null;
    boolean f = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findAncestor(root,p,q);
        return ans;
    }

    private boolean[] findAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return new boolean[]{false, false};
        }

        boolean[] l = findAncestor(node.left, p, q);
        boolean[] r = findAncestor(node.right, p, q);

        boolean[] next = new boolean[2];
        if (node == p) {
            next[0] = true;
        }

        if (node == q) {
            next[1] = true;
        }
        next[0] = l[0] || r[0] || next[0];
        next[1] = l[1] || r[1] || next[1];

        if(!f && next[0] && next[1]){
            ans = node;
            f = true;
        }
        return next;
    }


}
