package _002_LinkList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test {

    /**
     * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-interview-150
     * hash解法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        Map<Integer,ListNode> mp = new HashMap<>();
        ListNode h = new ListNode();
        h.next = head;

        ListNode cur = h;
        int index = 0;
        while (cur!=null){
            System.out.println("index: "+index+" node: "+cur);
            mp.put(index++,cur);
            cur = cur.next;
        }

        //正数第k个
        int k = index - n;
        //取要删除节点的前一个节点
        ListNode  pre = mp.get(k-1);
        System.out.println("node: "+pre);
        pre.next = pre.next.next;

        return h.next;
    }


    /**
     * 快慢指针解法
     * @param head
     * @param n
     * @return
     *
     * 1
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = new ListNode();
        h.next = head;

        ListNode cur = h;
        //slow记录要删除节点的前一个节点位置
        ListNode slow = h;

        int index = 0;
        while (cur!=null){
            if(index>n){
                slow = slow.next;
            }
            cur=cur.next;
            index++;
        }

        slow.next = slow.next.next;
        return h.next;
    }
}
