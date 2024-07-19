package _002_LinkList;

import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/palindrome-linked-list/?envType=study-plan-v2&envId=top-100-liked
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            len++;
        }

        int t = len/2;
        ListNode dumpy = new ListNode();
        cur = head;
        while (t>0){
            ListNode tmp = cur.next;
            cur.next = dumpy.next;
            dumpy.next = cur;
            cur = tmp;
            t--;
        }

        if(len%2==1){
            cur = cur.next;
        }

        //比较前后是否相等
        t = len/2;
        ListNode pre = dumpy.next;
        ListNode later = cur;
        while (t>0){
            if(pre.val!= later.val){
                return false;
            }
            pre = pre.next;
            later = later.next;
            t--;
        }
        return true;
    }
}
