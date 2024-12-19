package _009_Greedy;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-number-of-moves-to-seat-everyone/
 */
public class MinMovesToSeat {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        int n = seats.length;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        MinMovesToSeat t = new MinMovesToSeat();
        t.minMovesToSeat(new int[]{12,14,19,19,12}, new int[]{19,2,17,20,7});
    }
}
