package _007_Tree;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-binary-tree/
 */
public class ConstructMaximumBinaryTree {

    private TreeNode t = new TreeNode();
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        dfs(t,true,nums,0, nums.length-1);
        return t.left;
    }

    void dfs(TreeNode father ,boolean LR,int[] nums,int l,int r){
        if(l>r){
            return;
        }

        int maxV = nums[l];
        int index = l;
        int tIndex = l;
        while (index <= r){
            if(nums[index]>maxV){
                tIndex = index;
                maxV = nums[index];
            }
            index++;
        }
        TreeNode curNode = new TreeNode(maxV);

        if(LR){
            father.left = curNode;
        }else{
            father.right = curNode;
        }

        dfs(curNode,true,nums,l,tIndex-1);
        dfs(curNode,false,nums,tIndex+1,r);

    }
}
