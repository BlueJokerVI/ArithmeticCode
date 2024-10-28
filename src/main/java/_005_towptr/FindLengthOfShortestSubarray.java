package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
 */
public class FindLengthOfShortestSubarray {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        //(left,right)要删除的区间
        //计算right最小值
        int right = n - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        if (right == 0) {
            return 0;
        }
        int min = right;
        for (int left = 0; left == 0 || arr[left - 1] <= arr[left]; left++) {
            while (right < n && arr[left] > arr[right]) {
                right++;
            }

            min = Math.min(min, right - left - 1);

        }
        return min;
    }
}
