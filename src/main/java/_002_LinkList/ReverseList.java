package _002_LinkList;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-11-30  21:18
 * @Description: 206. 反转链表  ,头插法
 * @Version: 1.0
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {

        if(head==null) {
            return null;
        }


        //只有一个节点直接返回
        if(head.next==null){
            return head;
        }


        //下面最少有两个节点

        ListNode headNode = new ListNode();
        headNode.next = head;
        ListNode crrNode = head.next;
        ListNode nextNode;
        head.next = null;

        while (crrNode!=null){
            nextNode = crrNode.next;
            crrNode.next = headNode.next;
            headNode.next = crrNode;
            crrNode = nextNode;
        }

        return  headNode.next;
    }
}


