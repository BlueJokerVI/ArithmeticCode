package _014_heap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description:
 */
public class FindMaximizedCapital {

    class Node {
        int profit;
        int capital;
    }

    Node[] heap;
    int heapSize;

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        heap = new Node[profits.length];
        heapSize = heap.length;
        for (int i = 0; i < profits.length; i++) {
            Node node = new Node();
            node.capital = capital[i];
            node.profit = profits[i];
            heap[i] = node;
        }

        build();


        for (int i = 0; i < k; i++) {
           int[] v = canGetMaxProfit(w, 0);
            w += v[0];
            //找不到满足条件的理论时直接break
            if(v[1]==-1){
                break;
            }
            remove(v[1]);
        }
        return w;
    }

    // 1 2 3
    void build() {
        for (int i = (heapSize) / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    void heapify(int x) {
        int l = 2 * x + 1;
        int r = 2 * x + 2;

        int maxIndex = x;
        if (l < heapSize && heap[maxIndex].profit < heap[l].profit) {
            maxIndex = l;
        }
        if (r < heapSize && heap[maxIndex].profit < heap[r].profit) {
            maxIndex = r;
        }

        if (maxIndex != x) {
            swap(x, maxIndex);
            heapify(maxIndex);
        }
    }

    void swap(int x, int y) {
        Node tmp = heap[x];
        heap[x] = heap[y];
        heap[y] = tmp;
    }

    void remove(int index) {
        swap(index, heapSize - 1);
        heapSize--;
        heapify(index);
    }

    //获取从index开始满足条件的最大理论，v[0]是最大理论值，v[1]是对应堆节点的索引
    int[] canGetMaxProfit(int w, int index) {
        if (index >= heapSize) {
            return new int[]{0,-1};
        }
        if (heap[index].capital <= w) {
            return new int[]{heap[index].profit,index};
        } else {
            int[] l = canGetMaxProfit(w, index * 2 + 1);
            int[] r = canGetMaxProfit(w, index * 2 + 2);
            return l[0] > r[0] ? l : r;
        }
    }

    @Test
    public void test() {
        findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
    }

    //工具类写法
    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            int n = profits.length;
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new int[]{capital[i], profits[i]});
            }
            Collections.sort(list, (a, b)->a[0]-b[0]);
            PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->b-a);
            int i = 0;
            while (k-- > 0) {
                while (i < n && list.get(i)[0] <= w) q.add(list.get(i++)[1]);
                if (q.isEmpty()) break;
                w += q.poll();
            }
            return w;
        }
    }


}
