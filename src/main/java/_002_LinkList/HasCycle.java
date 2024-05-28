package _002_LinkList;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null) {
            slow = slow.next;
            if(fast.next!=null){
                fast = fast.next.next;
            }else {
                fast = null;
            }

            if(fast==null){
                return false;
            }

            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}
