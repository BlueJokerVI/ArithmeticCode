package _002_LinkList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test {

    /**
     * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-interview-150
     * hash解法
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        Map<Integer, ListNode> mp = new HashMap<>();
        ListNode h = new ListNode();
        h.next = head;

        ListNode cur = h;
        int index = 0;
        while (cur != null) {
            System.out.println("index: " + index + " node: " + cur);
            mp.put(index++, cur);
            cur = cur.next;
        }

        //正数第k个
        int k = index - n;
        //取要删除节点的前一个节点
        ListNode pre = mp.get(k - 1);
        System.out.println("node: " + pre);
        pre.next = pre.next.next;

        return h.next;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode ta = headA;
        ListNode tb = headB;
        ListNode ans = null;
        while (ta != null || tb != null) {
            if (ta != null) {
                ta = ta.next;
                lenA++;
            }
            if (tb != null) {
                tb = tb.next;
                lenB++;
            }
        }

        ta = headA;
        tb = headB;
        if (lenA > lenB) {
            ans = getListNode(lenA, lenB, ta, tb);
        } else {
            ans = getListNode(lenB, lenA, tb, ta);
        }

        return ans;

    }

    private static ListNode getListNode(int lenA, int lenB, ListNode ta, ListNode tb) {
        int preGo = lenA - lenB;
        while (preGo > 0) {
            ta = ta.next;
            preGo--;
        }
        while (ta != null) {
            if (ta == tb) {
                return ta;
            }
            ta = ta.next;
            tb = tb.next;
        }
        return null;
    }

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        // 1 2 3 4
        ListNode dumpy = new ListNode();
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = dumpy.next;
            dumpy.next = cur;
            cur = tmp;
        }

        return dumpy.next;
    }


    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;


        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    public ListNode detectCycle(ListNode head) {
        /**
         * 设head到环起点步数为n，slow进入环后走k步与fast相遇，环长m。
         * 从慢指针进环开始(此时慢指针走了n步)，快指针(走了2n步)已在环内走过n步，
         * 相遇时可以推导得：k%m = (2k+n)%m，即(k+n)/m == 0，所以慢指针再走n步就会到达环起点。
         */
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        int t = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            t++;
            if (fast == slow) {
                ListNode cur = head;
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
        return null;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dumpy = new ListNode();
        ListNode cur = dumpy;
        while (list1 != null && list2 != null) {
            ListNode tmp;
            if (list1.val < list2.val) {
                tmp = list1.next;
                cur.next = list1;
                list1 = tmp;
                cur = cur.next;
            } else {
                tmp = list2.next;
                cur.next = list2;
                list2 = tmp;
                cur = cur.next;
            }
        }

        while (list1 != null) {
            ListNode tmp = list1.next;
            cur.next = list1;
            list1 = tmp;
            cur = cur.next;
        }

        while (list2 != null) {
            ListNode tmp = list2.next;
            cur.next = list2;
            list2 = tmp;
            cur = cur.next;
        }
        cur.next = null;
        return dumpy.next;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int pre = 0;
        ListNode dumpy = new ListNode();
        ListNode last = dumpy;
        while (l1 != null && l2 != null) {
            int cur = (l1.val + l2.val + pre) % 10;
            pre = (l1.val + l2.val + pre) / 10;
            last.next = new ListNode(cur);
            last = last.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int cur = (l1.val + pre) % 10;
            pre = (l1.val + pre) / 10;
            last.next = new ListNode(cur);
            last = last.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int cur = (l2.val + pre) % 10;
            pre = (l2.val + pre) / 10;
            last.next = new ListNode(cur);
            last = last.next;
            l2 = l2.next;
        }

        if (pre != 0) {
            last.next = new ListNode(pre);
        }

        return dumpy.next;

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode dumpy = new ListNode();
        dumpy.next = head;
        ListNode slow = dumpy;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //此时slow指向要删除节点的前一个节点
        slow.next = slow.next.next;
        return dumpy.next;
    }


    public ListNode swapPairs(ListNode head) {
        ListNode dumpy = new ListNode();
        dumpy.next = head;
        ListNode pre = dumpy;

        while (pre.next != null && pre.next.next != null) {
            ListNode l = pre.next;
            ListNode r = pre.next.next;

            l.next = r.next;
            r.next = l;
            pre.next = r;

            pre = r.next;
        }

        return dumpy.next;
    }


    public ListNode reverseKGroup(ListNode head, int k) {


        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }

        //翻转次数
        int t = len / k;
        cur = head;
        ListNode pre = new ListNode();
        ListNode ans = head;
        ListNode last = null;
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < k; j++) {
                System.out.printf("%d ", cur.val);
                if (j == 0) {
                    last = cur;
                }
                ListNode tmp = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = tmp;
            }
            System.out.println();
            last.next = cur;
            if (i == 0) {
                ans = pre.next;
            }
            pre = last;

        }

        return ans;
    }

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
        Node dumpy = new Node(999);
        dumpy.next = head;
        //旧node -> 下标
        Map<Node, Integer> mp1 = new HashMap<>();
        //下标，新node
        Map<Integer, Node> mp2 = new HashMap<>();

        Node pre = dumpy;
        Node cur = head;
        int index = 1;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            mp1.put(cur, index);
            mp2.put(index++, node);

            pre.next = node;
            cur = cur.next;
            pre = node;

        }

        cur = head;
        Node newCur = dumpy.next;

        while (cur != null) {
            //System.out.printf("%d %d \n",cur.val,newCur.val);
            if (cur.random != null) {
                //System.out.printf("index:%d  value:%s\n",mp1.get(cur.random),mp2.get(mp1.get(cur.random)));
                newCur.random = mp2.get(mp1.get(cur.random));
            }
            cur = cur.next;
            newCur = newCur.next;
        }

        return dumpy.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode dumpy = new ListNode();
        ListNode pre = dumpy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            pre.next = l1;
        }

        if (l2 != null) {
            pre.next = l2;
        }
        return dumpy.next;
    }

    private ListNode merge(ListNode[] lists, int l, int r) {

        if (l > r) {
            return null;
        }

        if (l == r) {
            return lists[l];
        }

        if (l - r == 1) {
            return mergeTwo(lists[l], lists[r]);
        }

        int mid = l + (r - l) / 2;
        ListNode left = merge(lists, l, mid);
        ListNode right = merge(lists, mid + 1, r);

        return mergeTwo(left, right);
    }


    public ListNode sortList(ListNode head) {

        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }

        if (len == 0 || len==1) {
            return head;
        }


        int mid = len / 2;
        cur = head;
        ListNode late=null;
        while (mid > 0) {
            if (mid == 1) {
                //将前半个链表最后一节点next赋值null
                late = cur.next;
                cur.next = null;
                break;
            }
            cur = cur.next;
            mid--;
        }
        cur = head;
        ListNode left = sortList(cur);
        ListNode right = sortList(late);
        return mergeTwo(left,right);
    }


    @org.junit.Test
    public void test() {
        Node node = new Node(1);
        Set<Node> set = new HashSet<>();
        set.add(node);
        node.val = 2;
        if (set.contains(node)) {
            System.out.println(11);
        }
    }
}
