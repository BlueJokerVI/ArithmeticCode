package _005_towptr;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-size-subarray-in-infinite-array/
 */
public class MinSizeSubarray {
    public int minSizeSubarray(int[] nums, int target) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        long sumN = 0;
        for (int num : nums) {
            sumN += num;
        }
        long t = target / sumN;
        target = (int) (target % sumN);

        long m = sumN - target;
        int l = 0;
        long cur = 0;
        for (int i = 0; i < n * 2; i++) {
            cur += nums[i % n];

            while (cur >= m) {
                if (cur == m && i - l + 1 > max) {
                    max = i - l + 1;
                }
                cur -= nums[l % n];
                l++;
            }
        }

        return max == Integer.MIN_VALUE ? -1 : (int) (n - max + (t * n));
    }

    public static void main(String[] args) throws IOException {
        MinSizeSubarray minSizeSubarray = new MinSizeSubarray();
        int[] ints = readFileToIntArray("E:\\ArithmeticCode\\src\\main\\java\\_005_towptr\\data.txt");
        System.out.println(minSizeSubarray.minSizeSubarray(ints, 587344161));
    }

    public static int[] readFileToIntArray(String filePath) {
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 以逗号分割每个整数，并去除多余的空格
                String[] parts = line.split(",");
                for (String part : parts) {
                    numbers.add(Integer.parseInt(part.trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 将 List<Integer> 转换为 int[]
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }
}
