package _002_LinkList;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.PriorityQueue;

public class Main {
    static class Node implements Comparable<Node> {
        int key;
        int val;
        LocalDateTime useTime;

        Node(int key, int val, LocalDateTime useTime) {
            this.key = key;
            this.val = val;
            this.useTime = useTime;
        }

        @Override
        public int compareTo(Node other) {
            // 根据useTime进行排序
            return this.useTime.compareTo(other.useTime);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            // 只根据key判断是否相等
            return key == node.key;
        }

        @Override
        public int hashCode() {
            // 只根据key计算hashCode
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return "key: " + key + " val: " + val + " time: " + useTime;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        // 创建节点
        Node node1 = new Node(1, 100, LocalDateTime.now().plusSeconds(30));
        Node node2 = new Node(2, 200, LocalDateTime.now().plusSeconds(10));
        Node node3 = new Node(1, 300, LocalDateTime.now().plusSeconds(20)); // 与node1的key相同，但useTime不同

        // 插入节点
        priorityQueue.add(node1);
        priorityQueue.add(node2);

        // 尝试移除节点
        boolean remove = priorityQueue.remove(node3);
        System.out.println("Remove node3: " + remove); // 应该输出 true

        // 打印剩余元素
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
