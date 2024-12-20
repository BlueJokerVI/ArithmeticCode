package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-number-of-operations-to-make-arrays-similar/
 */
public class MakeSimilar {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);

        int n = nums.length;
        long t = 0;
        int l = 0, ro = -1, re = -1;

        for (int i = 0; i < target.length; i++) {
            if (re == -1 && target[i] % 2 == 0) {
                re = i;
            }
            if (ro == -1 && target[i] % 2 == 1) {
                ro = i;
            }
            if (ro != -1 && re != -1) {
                break;
            }
        }


        while (l < n) {
            if (nums[l] % 2 == 1) {
                if (ro < n && nums[l] > target[ro]) {
                    t += (nums[l] - target[ro]) / 2;
                }
                ro++;
                while (ro < n && target[ro] % 2 == 0) {
                    ro++;
                }
                l++;
            } else {
                if (re < n && nums[l] > target[re]) {
                    t += (nums[l] - target[re]) / 2;
                }
                re++;
                while (re < n && target[re] % 2 == 1) {
                    re++;
                }
                l++;
            }
        }

        return t;
    }

    public static void main(String[] args) {
        MakeSimilar t = new MakeSimilar();
        t.makeSimilar(new int[]{8,12,6},new int[]{2,14,10});
    }
}
