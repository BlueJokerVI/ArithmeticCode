package _007_Tree;

public class LowestCommonAncestor {

    int maxH = -1;
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,0,p,q);
        return ans;
    }

    int dfs(TreeNode node ,int h,TreeNode p,TreeNode q){
        if(node==null){
            return 0;
        }

        int l = dfs(node.left,h+1,p,q);
        int r = dfs(node.right,h+1,p,q);

        if(node==p || node==q){
            if(1+r+l==2){
                if(h>maxH){
                    maxH = h;
                    ans = node;
                }
                return 2;
            }
            return 1;
        }

        if(l+r==2){
            if(h>maxH){
                maxH = h;
                ans = node;
            }
            return 2;
        }

        return l+r;
    }

    //更简洁写法
    TreeNode dfs(TreeNode node,TreeNode p,TreeNode q){
        if(node==null || node ==p || node ==q){
            return node;
        }
        TreeNode left = dfs(node.left,p,q);
        TreeNode right = dfs(node.right,p,q);

        if(left==null && right==null){
            return null;
        }

        if(left==null) return right;
        if(right==null) return left;

        return node;

    }
}
