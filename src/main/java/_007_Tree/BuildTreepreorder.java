package _007_Tree;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class BuildTreepreorder {

    private TreeNode t = new TreeNode();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        dfs(t,true,inorder,preorder,0,preorder.length-1,0,preorder.length-1);
        return t.left;
    }


    /**
     * 解题思路，先序遍历数组的最后一个元素就是该树的根节点，中序遍历数组中根节点左右子数组分别对应是左右子树的中序遍历，
     * 且子树的根节点一定是父节点的儿子，递归解决
     * @param father 父节点
     * @param LR  标记当前节点是父节点的左子树还是右子树
     * @param inorder 树的中序遍历数组
     * @param preorder 先序遍历数组
     * @param l 中序遍历数组对应一颗子树的起始下标
     * @param r  终止下标
     * @param p_l  先序遍历数组对应一颗子树的起始下标
     * @param p_r  终止下标
     */
    void dfs(TreeNode father,boolean LR,int[] inorder ,int[] preorder,int l,int r,int p_l,int p_r){

        if(l>r){
            return;
        }

        int curRoot = preorder[p_l];

        int index = l;
        while (index<=r){
            if(inorder[index]==curRoot){
                break;
            }
            index++;
        }

        TreeNode curNode = new TreeNode(curRoot);
        if(LR){
            father.left = curNode;
        }else {
            father.right = curNode;
        }

        /**
         * index-1-l+1 = x - p_l-1 +1
         * x = index -l +p_l
         */

        dfs(curNode,true, inorder, preorder,l, index -1,p_l+1,index -l +p_l);

        dfs(curNode,false, inorder, preorder,index+1, r,index -l +p_l+1,p_r);
    }


    @Test
    public void test(){

    }
}


