package _007_Tree;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length-1);
    }

    TreeNode dfs(int[] nums,int l,int r){
        if(l>r){
            return null;
        }

        int cur = (l+r)/2 ;

        TreeNode treeNode = new TreeNode(nums[cur]);

        treeNode.left = dfs(nums,l,cur-1);
        treeNode.right = dfs(nums,cur+1,r);

        return treeNode;

    }
}
