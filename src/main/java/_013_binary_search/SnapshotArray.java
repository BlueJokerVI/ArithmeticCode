package _013_binary_search;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/snapshot-array/
 */
public class SnapshotArray {

    private final List<List<int[]>> arr = new ArrayList<>();
    private int version = 0;

    public SnapshotArray(int length) {
        for (int i = 0; i < length; i++) {
            ArrayList<int[]> ints = new ArrayList<>();
            ints.add(new int[]{version, 0});
            arr.add(ints);
        }
    }

    public void set(int index, int val) {
        List<int[]> ints = arr.get(index);
        ints.add(new int[]{version, val});
    }

    public int snap() {
        return version++;
    }

    public int get(int index, int snap_id) {
        List<int[]> ints = arr.get(index);
        int l = 0, r = ints.size() - 1;
        while (l <= r) {
            int mid = (r-l)/2 + l;
            if(ints.get(mid)[0] > snap_id){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return ints.get(r)[1];
    }


    public static void main(String[] args) {
        SnapshotArray t = new SnapshotArray(4);

        System.out.println(t.snap());
        System.out.println(t.snap());
        System.out.println(t.get(3, 1));
        t.set(2, 4);
        System.out.println(t.snap());
        t.set(1, 4);
    }


}
