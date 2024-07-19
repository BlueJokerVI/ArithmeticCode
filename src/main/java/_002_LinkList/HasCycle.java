package _002_LinkList;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        //有环的话，块指针一定追上慢指针
        while (fast!=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}
