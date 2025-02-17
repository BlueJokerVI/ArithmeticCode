package _002_LinkList;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-05  21:05
 * @Description: 链表节点类
 * @Version: 1.0
 */
public class ListNode{
    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    int val;
    ListNode next;
}