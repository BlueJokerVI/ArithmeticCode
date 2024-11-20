package _013_binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/range-frequency-queries/
 */
public class RangeFreqQuery {


    private Map<Integer, List<Integer>> mp = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for(int i = 0;i < arr.length;i++){
            mp.computeIfAbsent(arr[i],k -> new ArrayList<Integer>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        if (mp.containsKey(value)) {

            List<Integer> list = mp.get(value);
            int l = findGe(list, left);
            int r = findGe(list, right + 1);
            return r - l;
        } else {
            return 0;
        }
    }

    /**
     * 找到arr中第一个大于等于v的值的位置
     *
     * @param arr
     * @param v
     * @return
     */
    private int findGe(List<Integer> arr, int v) {
        int l = 0, r = arr.size() - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (arr.get(mid) < v) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }


}
