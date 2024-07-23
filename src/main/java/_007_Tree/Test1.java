package _007_Tree;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 左 中 有
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;  //非空一直往左
            } else {
                cur = s.pop();  //控就取栈顶元素
                ans.add(cur.val);
                cur = cur.right; //往右
            }
        }

        return ans;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val == right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                tmp.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = sortedArrayToBST(nums, l, mid - 1);
        cur.right = sortedArrayToBST(nums, mid + 1, r);
        return cur;
    }


    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {

        if (root == null) {
            return true;
        }


        if (root.val < max && root.val > min) {
            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        } else {
            return false;
        }
    }

    int k;
    int cnt;
    int ans;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null || cnt == k) {
            return;
        }
        dfs(root.left);
        cnt++;
        if (cnt == k) {
            ans = root.val;
            return;
        }
        dfs(root.right);
    }


    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }

                if (i == size - 1) {
                    ans.add(cur.val);
                }
            }
        }
        return ans;
    }


    public void flatten(TreeNode root) {
        flattenDfs(root);
    }


    //返回左子树的最后一个节点
    private TreeNode flattenDfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmpR = root.right;
        TreeNode tmpL = root.left;
        root.left = null;

        TreeNode last;
        if (tmpL != null) {
            root.right = tmpL;
            last = flattenDfs(tmpL);
            last.right = tmpR;
            if(tmpR == null){
                return last;
            }
            return flattenDfs(tmpR);
        } else if (tmpR != null) {
            return flattenDfs(tmpR);
        } else {
            return root;
        }
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeDfs(preorder,0, preorder.length-1, inorder, 0,inorder.length-1);
    }

    //preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    private TreeNode buildTreeDfs(int[] preorder,int l,int r,int[] inorder,int s,int e){
        if(l>r || s>e){
            return null;
        }

        TreeNode cur = new TreeNode(preorder[l]);
        int index = s;
        while (inorder[index]!=cur.val){
            index++;
        }

        //index-s+l = x
        cur.left = buildTreeDfs(preorder,l+1,index-s+l,inorder,s,index-1);
        cur.right = buildTreeDfs(preorder,index-s+l+1,r,inorder,index+1,e);
        return cur;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcaDfs(root, p, q);
    }


    private TreeNode lcaDfs(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        TreeNode l = lcaDfs(root.left,p,q);
        TreeNode r = lcaDfs(root.right,p,q);

        if((l==p && r==q) || (r==p && l==q)){
            return root;
        }else if(root==p || root==q){
            return root;
        }else if(l==null){
            return r;
        }else {
            return l;
        }
    }


    int maxV = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumDfs(root);
        return maxV;
    }
    public int maxPathSumDfs(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l = maxPathSumDfs(root.left);
        int r = maxPathSumDfs(root.right);
//        System.out.println("root: "+root.val +"   l: "+l +"   r:"+r);
        int cur =  root.val + Math.max(0,l) + Math.max(0,r);
        if(cur > maxV){
            maxV = cur;
        }
        return root.val+Math.max(Math.max(0,l) , Math.max(0,r));
    }

}
