package _002_LinkList;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
*@BelongsProject: ArithmeticCode
*@Author: cct
*@Description: TODO
*/
public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }



    public Node copyRandomList(Node head) {

        if(head==null){
            return null;
        }

        Map<Node,Integer> mp2 = new HashMap<>();

        int index = 0;
        Node tmp = head;
        while (tmp!=null){
            mp2.put(tmp,index++);
            tmp = tmp.next;
        }
        Node h = dfs(head);
        tmp = h;

        while (head!=null){

            if(head.random==null){
                tmp.random = null;
            }else {
                Integer pos = mp2.get(head.random);
                System.out.println("head: "+head + " pos: " +pos);
                tmp.random = getNode(pos,h);
            }
            System.out.println("head: "+head + " : " +head.random);
            System.out.println("tmp: "+tmp + " : " +tmp.random);
            head = head.next;
            tmp = tmp.next;
        }

        return h;
    }


    public Node dfs(Node h){
        Node ans = new Node(h.val);
        if(h.next!=null){
            ans.next = dfs(h.next);
        }
        return ans;
    }

    Node getNode(int index,Node head){
        while (index!=0){
            head = head.next;
            index--;
        }
        return head;
    }



    class Solution {
        public Node copyRandomList(Node head) {
            if(head == null) return null;
            Node cur = head;
            Map<Node, Node> map = new HashMap<>();
            // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
            while(cur != null) {
                map.put(cur, new Node(cur.val));
                cur = cur.next;
            }
            cur = head;
            // 4. 构建新链表的 next 和 random 指向
            while(cur != null) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            // 5. 返回新链表的头节点
            return map.get(head);
        }
    }

    @Test
    public void test(){
        Map<Node,Integer> mp2 = new HashMap<>();
        Node node = new Node(1);
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        mp2.put(node,1);
        mp2.put(node1,2);
        mp2.put(node2,3);
        Integer integer = mp2.get(node2);
        System.out.println(integer);
    }
}
