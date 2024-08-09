package _012_graphic;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/contest/weekly-contest-324/problems/add-edges-to-make-degrees-of-all-nodes-even/
 */
public class IsPossible {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        //度全为偶数 true
        //度为奇数的节点有奇数个 false
        //度为奇数的节点有2，4 可能true，否则为false

        boolean[] in = new boolean[n + 1];
        //in[i]= false 度为偶数
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for (List<Integer> edge : edges) {
            int i = edge.get(0);
            int j = edge.get(1);
            in[i] = !in[i];
            in[j] = !in[j];
            if (mp.containsKey(i)) {
                Set<Integer> set = mp.get(i);
                set.add(j);
            }else {
                Set<Integer> set = new HashSet<>();
                set.add(j);
                mp.put(i,set);
            }

            if (mp.containsKey(j)) {
                Set<Integer> set = mp.get(j);
                set.add(i);
            }else {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                mp.put(j,set);
            }
        }

        int cnt = 0;
        List<Integer> points = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (in[i]) {
                cnt++;
                points.add(i);
            }
        }

        if (cnt == 0) {
            return true;
        }

        if (cnt == 2) {
            int i = points.get(0);
            int j = points.get(1);


            if(!mp.get(i).contains(j)){
                return true;
            }else {
                for (int k = 1; k <= n; k++) {

                    if(k!=i && k!=j && !mp.get(i).contains(k) && !mp.get(j).contains(k)){
                        return true;
                    }
                }
                return false;
            }
        }

        if (cnt == 4) {
            int i = points.get(0);
            int j = points.get(1);
            int k = points.get(2);
            int m = points.get(3);


            if (!mp.get(i).contains(j) && !mp.get(k).contains(m)) {
                return true;
            }

            if (!mp.get(i).contains(k) && !mp.get(j).contains(m)) {
                return true;
            }

            return !mp.get(i).contains(m) && !mp.get(j).contains(k);
        }

        return false;
    }

    @Test
    public void test() {
        int[][] arr = new int[][]{
                
                        {1,2},{2,3},{2,4},{3,4}
        };
                
        List<List<Integer>> lists = new ArrayList<>();
        for (int[] ints : arr) {
            List<Integer> ll = new ArrayList<>();
            for (int anInt : ints) {
                ll.add(anInt);
            }
            lists.add(ll);
        }
        isPossible(4, lists);
    }
}
