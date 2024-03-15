package _007_Tree;

import java.util.ArrayList;
import java.util.List;

public class FindMode {
    int maxCnt = 0;
    int cCnt = 0;
    int pre = -999999;
    List<Integer> ans = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        //最后相同的节点也要判断
        if (cCnt > maxCnt) {
            ans.clear();
            ans.add(pre);
            maxCnt = cCnt;
        } else if (cCnt == maxCnt) {
            ans.add(pre);
        }
        return ans.stream().mapToInt(e -> e).toArray();
    }

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        if (pre == -999999) {
            pre = node.val;
            cCnt = 1;
        } else {
            if (node.val != pre) {
                if (cCnt > maxCnt) {
                    ans.clear();
                    ans.add(pre);
                    maxCnt = cCnt;
                } else if (cCnt == maxCnt) {
                    ans.add(pre);
                }
                cCnt = 1;
                pre = node.val;
            } else {
                cCnt++;
            }
        }
        dfs(node.right);
    }


    //简介写法
    public void findMode1(TreeNode root) {
        if (root == null) {
            return;
        }
        findMode1(root.left);

        int rootValue = root.val;
        // 计数
        if (pre == -999999 || rootValue != pre) {
            cCnt = 1;
        } else {
            cCnt++;
        }
        // 更新结果以及maxCount
        if (cCnt > maxCnt) {
            ans.clear();
            ans.add(rootValue);
            maxCnt = cCnt;
        } else if (cCnt == maxCnt) {
            ans.add(rootValue);
        }
        pre = rootValue;

        findMode1(root.right);
    }
}
