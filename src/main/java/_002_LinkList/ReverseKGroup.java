package _002_LinkList;

import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode h = new ListNode();
        h.next = head;

        //计算链表长度
        int len = 0;
        ListNode pos = head;
        while (pos!=null){
            len++;
            pos=pos.next;
        }

        //需要翻转次数
        int time = len / k;


        //pos记录每次要反转串的前一个节点
        pos = h;
        for (int i = 0; i < time; i++) {

            ListNode pre = pos;
            ListNode cur = pos.next;
            ListNode tmp;
            for (int j = 0; j < k; j++) {
                tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }

            tmp = pos.next;
            pos.next.next = cur;
            pos.next = pre;
            //更新pos，下次反转的头节点
            pos = tmp;
        }

        return h.next;
    }
}
