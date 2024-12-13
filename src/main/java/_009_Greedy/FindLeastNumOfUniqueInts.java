package _009_Greedy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

/**
 * @author cct
 * https://leetcode.cn/problems/least-number-of-unique-integers-after-k-removals/
 */
public class FindLeastNumOfUniqueInts {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int dif = 0;
        for (int v : arr) {
            mp.put(v, mp.getOrDefault(v, 0) + 1);
            if (mp.get(v) == 1) {
                dif++;
            }
        }

        List<Map.Entry<Integer, Integer>> collect = mp.entrySet().stream().sorted((a, b) -> a.getValue() - b.getValue()).collect(Collectors.toList());
        for (Map.Entry<Integer, Integer> entry : collect) {
            if(entry.getValue() <= k){
                k-=entry.getValue();
                dif--;
            }
        }
        return dif;
    }

    public static void main(String[] args) {
        FindLeastNumOfUniqueInts t = new FindLeastNumOfUniqueInts();
        t.findLeastNumOfUniqueInts(new int[]{2,4,1,8,3,5,1,3},3);
    }
}
