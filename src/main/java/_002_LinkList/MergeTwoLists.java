package _002_LinkList;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-interview-150
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }

        if(list2==null){
            return list1;
        }

        ListNode ans = null;
        ListNode index = null;
        if(list1.val <= list2.val ){
            ans = list1;
            index = list1;
            list1=list1.next;
        }else {
            ans = list2;
            index = list2;
            list2 = list2.next;
        }

        while (list1!=null & list2!=null){
            if(list1.val <= list2.val){
                index.next = list1;
                list1=list1.next;
            }else {
                index.next = list2;
                list2=list2.next;
            }
            index = index.next;
        }

        if (list1!=null){
            index.next = list1;
        }

        if(list2!=null){
            index.next = list2;
        }

        return ans;
    }
}
