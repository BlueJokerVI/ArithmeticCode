package _002_LinkList;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-05  21:07
 * @Description: 19. 删除链表的倒数第 N 个结点
 * @Version: 1.0
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null){
            return null;
        }

        ListNode pre = head;

        //无数据头节点方便操作
        ListNode tmpHead = new ListNode();
        tmpHead.next = head;


        //later指向要删除节点的前一个节点
        ListNode later = tmpHead;;

        for(int i=1;i<n;i++){
            pre = pre.next;


            //链表中没有n个节点直接返回
            if(pre==null){
                return head;
            }
        }

        // 1 2 3

        while (pre.next!=null){
            pre = pre.next;
            later = later.next;
        }

        later.next = later.next.next;

        return tmpHead.next;
    }
}
