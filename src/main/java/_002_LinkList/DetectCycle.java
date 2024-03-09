package _002_LinkList;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-07  16:49
 * @Description: https://leetcode.cn/problems/linked-list-cycle-ii/description/
 * 142. 环形链表 II
 * @Version: 1.0
 */
public class DetectCycle {

    //暴力set
    public ListNode detectCycle1(ListNode head) {
        if(head==null){
            return null;
        }

        Set<ListNode> set = new HashSet<>();
        ListNode tmp = head;
        while (tmp!=null){

            if(set.contains(tmp)){
                return tmp;
            }
            set.add(tmp);
            tmp = tmp.next;
        }

        return null;
    }


    //双指针，数学

    /**
     * https://leetcode.cn/problems/linked-list-cycle-ii/solutions/12616/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if(head==null){
            return null;
        }

        ListNode f ,s;
        f = head;
        s = head;

        while (true) {

            if(f == null || f.next == null){
                return null;
            }
            f = f.next.next;
            s = s.next;

            //第一次相遇
            if (f == s) {
                break;
            }

        }

        f = head;

        while (f!=s){
            f = f.next;
            s = s.next;
        }
        return f;
    }

}
