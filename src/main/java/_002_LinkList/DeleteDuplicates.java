package _002_LinkList;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode h = new ListNode();
        h.next = head;
        ListNode cur = h;
        while (true) {
            ListNode v1 = cur.next;
            if (v1 == null) {
                break;
            }
            ListNode v2 = v1.next;
            if (v2 == null) {
                break;
            }

            if (v1.val != v2.val) {
                cur = v1;
            } else {
                while (v2!=null && v2.val == v1.val) {
                    v2 = v2.next;
                }
                cur.next =v2;
            }
        }
        return h.next;
    }
}
