package _002_LinkList;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/reverse-linked-list-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseBetween {

    Map<Integer,ListNode> mp = new HashMap<>();
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }

        ListNode t = new ListNode();
        t.next = head;


        int index = 0;
        ListNode tmp = t;
        while (index <= right){
            mp.put(index,tmp);
            tmp = tmp.next;
            index++;
        }
        print(t);

        while (left<right){
            System.out.println("left: "+left+" right: "+right);
            if(left+1==right){
                ListNode p = mp.get(left - 1);
                ListNode q = mp.get(right - 1);
                System.out.printf("p: %d  q:%d\n",p.val,q.val);
                changePosClose(p,q,left,right);
                print(t);
            }else {
                ListNode p = mp.get(left - 1);
                ListNode q = mp.get(right - 1);
                System.out.printf("p: %d  q:%d\n",p.val,q.val);
                changePos(mp.get(left-1),mp.get(right-1),left,right);
                print(t);
            }
            left++;
            right--;
        }
        return t.next;
    }

    //交换v1与v2后的节点v1 v2不相邻
    void changePos(ListNode a,ListNode d ,int l,int r){


        //要交换的两个节点
        //  a  b  c
        //  d  e  f
        ListNode b = a.next;
        ListNode e = d.next;
        ListNode c = b.next;
        b.next = e.next;
        e.next = c;

        a.next = e;
        d.next = b;
        mp.put(l,a.next);
        mp.put(r,b.next);

    }

    //v1 v2相邻
    void changePosClose(ListNode a,ListNode b,int l,int r){
        //a b c
        ListNode c = b.next;
        b.next = c.next;
        c.next = b;
        a.next = c;
        mp.put(l,a.next);
        mp.put(r,a.next.next);
    }

    void print(ListNode node) {
        while (node!=null){
            System.out.printf("%d ",node.val);
            node = node.next;
        }
        System.out.println();
    }


    //简洁写法
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(0, head), p0 = dummy;
            for (int i = 0; i < left - 1; ++i) {
                p0 = p0.next;
            }

            //此时p0指向要反转的部分的前一个节点
            ListNode pre = null, cur = p0.next;
            for (int i = 0; i < right - left + 1; ++i) {
                ListNode nxt = cur.next;
                cur.next = pre; // 每次循环只修改一个 next，方便大家理解
                pre = cur;
                cur = nxt;
            }

            // 将原第一个节点的next指向翻转链表最后一节点的next
            p0.next.next = cur;
            p0.next = pre;
            return dummy.next;
        }
    }

}
