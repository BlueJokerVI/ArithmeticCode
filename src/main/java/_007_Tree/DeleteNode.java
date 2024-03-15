package _007_Tree;

import org.apache.poi.ss.formula.functions.T;

import java.time.temporal.Temporal;

public class DeleteNode {


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        TreeNode node = new TreeNode(1);
        node.left = root;
        dfs(root,node,true,key);

        return node.left;
    }


    //找左子树最小值替换被删除的位置0.o
    void dfs(TreeNode node, TreeNode father, boolean LR, int key) {
        if (node == null) {
            return;
        }

        if (node.val > key) {
            dfs(node.left, node, true, key);
        } else if (node.val < key) {
            dfs(node.right, node, false, key);
        } else {
            //无右子树
            if(node.right==null){
                if(LR){
                    father.left = node.left;
                }else {
                    father.right = node.left;
                }
            }else if(node.right.left==null){
                //右子树,没有左子树
                TreeNode cNode = node.right;
                cNode.left = node.left;

                if(LR){
                    father.left = cNode;
                }else {
                    father.right = cNode;
                }
            }else {
                //右子树有多个节点
                TreeNode cNode = findRightMin(node);
                cNode.left = node.left;
                cNode.right = node.right;

                if(LR){
                    father.left = cNode;
                }else {
                    father.right = cNode;
                }
            }
        }
    }


    TreeNode findRightMin(TreeNode root) {
        TreeNode tmp = root.right;

        //找最左下角节点的父节点
        while (tmp.left.left != null) {
            tmp = tmp.left;
        }

        TreeNode v = tmp.left;
        tmp.left = v.right;
        return v;
    }


    /**
     * 第一种情况：没找到删除的节点，遍历到空节点直接返回了
     * 找到删除的节点
     * 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
     * 第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
     * 第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
     * 第五种情况：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        if (root.val > key) {
            root.left = deleteNode1(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode1(root.right, key);
        }
        return root;
    }
}
