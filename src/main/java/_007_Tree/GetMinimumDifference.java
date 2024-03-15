package _007_Tree;

public class GetMinimumDifference {

    Integer minV = Integer.MAX_VALUE;
    Integer preV;
    boolean f = false;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minV;
    }


    void dfs(TreeNode node){
        if(node==null){
            return;
        }

        dfs(node.left);
        if (!f){
            preV = node.val;
            f = true;
        }else{
            Integer curGap = Math.abs(node.val - preV);
            if(curGap<minV){
                minV = curGap;
            }
            preV = node.val;
        }
        dfs(node.right);

    }
}
