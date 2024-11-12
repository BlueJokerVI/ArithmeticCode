package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/duplicate-zeros/
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int[] tmps = new int[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                tmps[index++] = arr[i];
                if (index == 0) {
                    break;
                }
            } else {
                tmps[index++] = 0;
                if (index == 0) {
                    break;
                }
                tmps[index++] = 0;
                if (index == 0) {
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = tmps[i];
        }

    }
}
