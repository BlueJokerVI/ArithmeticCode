package _002_LinkList;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-02  21:13
 * @Description: 24. 两两交换链表中的节点
 * @Version: 1.0
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {

        if(head==null){
            return null;
        }

        if(head.next==null){
            return head;
        }


        //往下走最少有两个节点

        ListNode falseHead = new ListNode();
        falseHead.next = head;

        ListNode t1 = falseHead;
        ListNode t2 = null;
        // 1  2  3  4 -> 1 3 2 4
        while (t1.next!=null&&t1.next.next!=null){

            //暂存3
            t2 = t1.next.next;

            //2->4
            t1.next.next = t1.next.next.next;

            //3->2
            t2.next = t1.next;

            //1->3
            t1.next = t2;

            t1 = t1.next.next;

        }

        return falseHead.next;

    }

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

}
