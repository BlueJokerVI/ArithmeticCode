package _002_LinkList;

import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/merge-k-sorted-lists/?envType=study-plan-v2&envId=top-interview-150
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }

        return dfs(lists,0,lists.length-1);
    }

    ListNode dfs(ListNode[] lists,int l,int r){
        if(l==r){
            return lists[l];
        }

        // - -    - - -
        int mid = (l+r)/2;
        ListNode left = dfs(lists,l,mid);
        ListNode right = dfs(lists,mid+1,r);

        ListNode dumpy = new ListNode();
        ListNode cur = dumpy;

        while (left!=null && right!=null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        cur.next = left==null ? right : left;
        return dumpy.next;
    }
}
