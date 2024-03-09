package _002_LinkList;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-11-29  21:36
 * @Description: leetcode:707. 设计链表:链表的基本操作
 * @Version: 1.0
 */



public class MyLinkedList {

    /**
     * 包含链表头的链表
     */
    private  ListNode list;

    public MyLinkedList() {
        list  = new ListNode();
    }

    /**
     * 打印列表
     */
    public void print(){
        ListNode tmp = list.next;
        while (tmp!=null){
            System.out.print(tmp.val+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public int get(int index) {
        if(index<0) {
            return -1;
        }
        ListNode tmp = list.next;

        while (tmp!=null){
            if(index==0){
                return tmp.val;
            }
            tmp = tmp.next;
            index--;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = list.next;
        list.next = newNode;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode tmp = list;

        //找到最后一个节点
        while (tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        if (index<0){
            return;
        }
        ListNode tmp = list;
        while (index!=0){
            if(tmp.next==null){
                //index大于链表长度不插入
                return;
            }
            tmp = tmp.next;
            index--;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = tmp.next;
        tmp.next = newNode;

    }

    public void deleteAtIndex(int index) {
        if(index<0) {
            return;
        }
        ListNode tmp = list;

        //找要删除节点的前一个节点
        while (index!=0){
            if(tmp.next==null){
                return;
            }
            tmp = tmp.next;
            index--;
        }
        if(tmp.next!=null){
            tmp.next = tmp.next.next;
        }
    }

    @Test
    public void test(){
        // 6 4 6 1 2  0 0 4
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(1, 0);
        myLinkedList.print();
        myLinkedList.deleteAtIndex(2);
        myLinkedList.print();
        myLinkedList.addAtHead(6);
        myLinkedList.print();
        myLinkedList.addAtTail(4);
        myLinkedList.print();
        myLinkedList.get(4);
        myLinkedList.print();
        myLinkedList.addAtHead(4);
        myLinkedList.print();
        myLinkedList.addAtIndex(5, 0);
        myLinkedList.print();
        myLinkedList.addAtHead(6);
        myLinkedList.print();
    }
}
