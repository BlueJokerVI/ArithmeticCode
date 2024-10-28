package _005_towptr;

import javafx.util.Pair;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/
 */
public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {

        int[][] arr = nums.stream().map(list -> list.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);


        int k = nums.size();
        //记录k个数组的枚举下标
        int[] index = new int[k];

        //记录答案
        int[] ans = new int[2];

        //暂存最小最大节点所属数组下标
        int[] tmp = new int[2];


        //左边节点取自那个数组
        int l = 0;
        //右边节点取自那个数组
        int r = 0;


        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        heap.add(new Pair<>(0, arr[0][0]));
        for (int i = 1; i < k; i++) {
            int v = arr[i][0];
            heap.add(new Pair<>(i, v));
            if (v < arr[l][0]) {
                l = i;
            }
            if (v > arr[r][0]) {
                r = i;
            }
        }

        tmp[0] = l;
        ans[0] = arr[tmp[0]][index[tmp[0]]];
        tmp[1] = r;
        ans[1] = arr[tmp[1]][index[tmp[1]]];


        //每次更新最小节点所属数组
        while (arr[l].length != index[l] + 1) {
            heap.poll();
            int v = arr[l][index[l] + 1];
            index[l]++;
            heap.add(new Pair<>(l, v));
            tmp[0] = heap.peek().getKey();
            if (v > arr[tmp[1]][index[tmp[1]]]) {
                tmp[1] = l;
            }

            if (arr[tmp[1]][index[tmp[1]]] - arr[tmp[0]][index[tmp[0]]] == ans[1] - ans[0]
                    && arr[tmp[0]][index[tmp[0]]] < ans[0]
                    || arr[tmp[1]][index[tmp[1]]] - arr[tmp[0]][index[tmp[0]]] < ans[1] - ans[0]
            ) {
                ans[0] = arr[tmp[0]][index[tmp[0]]];
                ans[1] = arr[tmp[1]][index[tmp[1]]];
            }
            l = tmp[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4,10,15,24,26));
        nums.add(Arrays.asList(0,9,12,20));
        nums.add(Arrays.asList(5,18,22,30));
        SmallestRange smallestRange = new SmallestRange();
        smallestRange.smallestRange(nums);
    }
}
