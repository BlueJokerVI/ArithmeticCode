package _002_LinkList;

import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/sort-list/?envType=study-plan-v2&envId=top-interview-150
 */
public class SortList {

    //并归排序
    public ListNode sortList(ListNode head) {

        //拆分到最后一节点直接返回
        if (head == null || head.next==null) {
            return head;
        }
        ListNode dumpy = new ListNode();
        dumpy.next = head;
        ListNode fast = dumpy, slow = dumpy;
        //  - - -  /  - - - -
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //截断前半段链表
        ListNode l2 = slow.next;
        slow.next = null;
        ListNode n1 = sortList(head);
        ListNode n2 = sortList(l2);

        ListNode ans = new ListNode();
        ListNode cur = ans;

        while (n1!=null && n2!=null){
            if(n1.val < n2.val){
                cur.next = n1;
                n1 = n1.next;
            }else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }

        cur.next = n1==null ? n2 : n1;

        return ans.next;
    }

    //快排
    class Solution {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode node = new ListNode(0);
            node.next = head;
            sort(node,null);
            return node.next;
        }

        public void sort(ListNode head,ListNode end) {
            if(head == end || head.next == end || head.next.next == end){
                return;
            }
            ListNode cur = head.next;
            ListNode pre = head.next;
            while(pre != end && pre.next != end){
                ListNode node = pre.next;
                if(node.val < cur.val){
                    pre.next = pre.next.next;
                    ListNode tt = head.next;
                    head.next = node;
                    node.next = tt;
                } else {
                    pre = pre.next;
                }
            }
            sort(head,cur);
            sort(cur,end);
        }
    }
}
