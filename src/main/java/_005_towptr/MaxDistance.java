package _005_towptr;

import _021_utils.FileToArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-distance-between-a-pair-of-values/
 */
public class MaxDistance {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = n - 1, j = m - 1;
        int ans = 0;
        if (j < i) {
            i = j;
        }

        // 100 2            6 1
        while (j >= i && i >= 0 && j >= 0) {
            while (i >= 0 && nums2[j] < nums1[i]) {
                if(i==j){
                    i--;
                }
                j--;
            }

            while (i >= 0 && nums2[j] >= nums1[i]) {
                i--;
            }

            if (i >= 0) {
                ans = Math.max(ans, j - i - 1);
            } else {
                ans = Math.max(ans, j);
            }

        }
        return ans;
    }

    public static void main(String[] args) {

        int[] array1 = null;
        int[] array2 = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("E:\\ArithmeticCode\\src\\main\\java\\_020_utils\\in.txt"))) {
            String line1 = reader.readLine(); // 读取第一行
            String line2 = reader.readLine(); // 读取第二行

            if (line1 != null) {
                array1 = FileToArray.parseLineToArray(line1);
            }
            if (line2 != null) {
                array2 = FileToArray.parseLineToArray(line2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        MaxDistance tmp = new MaxDistance();
        tmp.maxDistance(array1, array2);
    }
}
