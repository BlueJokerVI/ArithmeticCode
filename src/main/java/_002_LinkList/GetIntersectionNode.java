package _002_LinkList;

import java.util.Stack;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-06  21:22
 * @Description: https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/description/
 * 面试题 02.07. 链表相交
 * @Version: 1.0
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA==null  || headB==null){
            return null;
        }

        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        ListNode ha = headA;
        ListNode hb = headB;

        while (ha!=null){
            s1.push(ha);
            ha = ha.next;
        }

        while (hb!=null){
            s2.push(hb);
            hb =hb.next;
        }


        //ha,hb表示当前相同的节点
        ha = s1.peek();
        hb = s2.peek();

        if(!ha.equals(hb)){
            return null;
        }
        s1.pop();
        s2.pop();

        while (!s1.empty()&&!s2.empty()){
            if(s1.peek().equals(s2.peek())){
                ha = s1.pop();
                s2.pop();
            }else {
                return ha;
            }
        }

        return ha;
    }

}
