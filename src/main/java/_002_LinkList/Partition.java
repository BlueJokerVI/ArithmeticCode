package _002_LinkList;

import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/partition-list/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode s = new ListNode();
        ListNode l = new ListNode();
        ListNode s1 = s;
        ListNode l1 = l;
        while (head!=null){
            if(head.val < x){
                s1.next = head;
                s1 = s1.next;
            }else {
                l1.next = head;
                l1 = l1.next;
            }
            head = head.next;
        }
        s1.next = l.next;
        l1.next = null;
        return s.next;
    }
}
