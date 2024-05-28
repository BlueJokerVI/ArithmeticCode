package _002_LinkList;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/add-two-numbers/?envType=study-plan-v2&envId=top-interview-150
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = l1;
        ListNode preL1 = l1;
        int pre = 0;
        while (l1 != null && l2 != null) {
            int v = l1.val + l2.val + pre;
            pre = v / 10;
            v %= 10;
            l1.val = v;

            if (l1.next == null) {
                preL1 = l1;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1==null && l2==null && pre!=0){
            preL1.next = new ListNode();
            preL1.next.val = pre;
        }
        
        
        if (l2 != null) {
            preL1.next = l2;
            while (l2!=null && pre != 0) {
                l2.val += pre;
                pre = l2.val / 10;
                l2.val = l2.val % 10;
                if(l2.next==null && pre!=0){
                    l2.next = new ListNode();
                }
                l2=l2.next;
            }
        }
        
        while (l1!=null && pre!=0){
            l1.val += pre;
            pre = l1.val / 10;
            l1.val = l1.val % 10;

            if(l1.next==null && pre!=0){
                l1.next = new ListNode();
            }
            l1=l1.next;
        }

        return listNode;

    }
}
