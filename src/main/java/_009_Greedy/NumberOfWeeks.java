package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-number-of-weeks-for-which-you-can-work/
 */
public class NumberOfWeeks {
    public long numberOfWeeks(int[] milestones) {
        long s = 0;
        int m = 0;
        for (int x : milestones) {
            s += x;
            m = Math.max(m, x);
        }
        return m > s - m + 1 ? (s - m) * 2 + 1 : s;
    }


    public static void main(String[] args) {
        NumberOfWeeks t = new NumberOfWeeks();
        t.numberOfWeeks(new int[]{1, 2, 3});
    }
}
