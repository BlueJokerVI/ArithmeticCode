package _002_LinkList;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/rotate-list/?envType=study-plan-v2&envId=top-interview-150
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode h = new ListNode();
        h.next = head;
        int len = 0;
        ListNode pos = head;
        while (pos != null) {
            pos = pos.next;
            len++;
        }
        if(len<=1){
            return head;
        }

        k = k % len;
        if(k==0){
            return head;
        }

        //正数第index为新头节点的前一个节点
        int index = len - k;
        pos = h;
        for (int i = 0; i < index; i++) {
            pos = pos.next;
        }
        ListNode newH = pos.next;
        pos.next = null;
        pos = newH;
        while (pos.next!=null){
            pos = pos.next;
        }
        pos.next = h.next;

        return newH;
    }
}
