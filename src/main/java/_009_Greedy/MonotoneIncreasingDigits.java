package _009_Greedy;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/monotone-increasing-digits/
 */
public class MonotoneIncreasingDigits {

    List<Integer> ans = new ArrayList<>();

    public int monotoneIncreasingDigits(int n) {
        int[] arr = getInts(n);
        dfs(0, 0, arr, false);
        int sum = 0;
        for (Integer an : ans) {
            sum = sum * 10 + an;
        }
        return sum;
    }


    /**
     * 回溯暴力解法
     *
     * @param index
     * @param pre
     * @param arr
     * @param isNine 控制遍历起点是否从9开始
     * @return
     */
    boolean dfs(int index, int pre, int[] arr, boolean isNine) {
        if (ans.size() == arr.length) {
            return true;
        }
        int v;
        if (isNine) {
            v = 9;
        } else {
            v = arr[index];
        }

        for (int i = v; i >= pre; i--) {
            ans.add(i);
            if (i != v) {
                if (dfs(index + 1, i, arr, true)) {
                    return true;
                }
            } else {
                if (dfs(index + 1, i, arr, isNine)) {
                    return true;
                }
            }
            ans.remove(ans.size() - 1);
        }
        return false;
    }


    int[] getInts(int n) {
        Deque<Integer> stack = new ArrayDeque();

        while (n > 0) {
            int tmp = n % 10;
            n /= 10;
            stack.push(tmp);
        }

        int[] arr = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            arr[index++] = stack.pop();
        }
        return arr;
    }


    /**
     * 贪心，反向遍历，标记9开始的位置
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits1(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length();
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i+1;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    @Test
    public void test() {
        monotoneIncreasingDigits(999998);
    }
}
