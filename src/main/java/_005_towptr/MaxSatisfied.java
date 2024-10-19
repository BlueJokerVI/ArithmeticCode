package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/grumpy-bookstore-owner/
 */
public class MaxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int max = 0;
        int sum = 0;
        int cur = 0;
        int n = customers.length;

        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            } else {
                cur += customers[i];
            }
        }

        if (cur > max) {
            max = cur;
        }

        for (int i = minutes; i < n; i++) {

            if (grumpy[i] == 0) {
                sum += customers[i];
            } else {
                cur += customers[i];
            }

            if (grumpy[i - minutes] == 1) {
                cur -= customers[i - minutes];
            }

            if (cur > max) {
                max = cur;
            }

        }
        return sum + max;
    }
}
