package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-possible-number-by-binary-concatenation/
 */
public class MaxGoodNumber {
    public int maxGoodNumber(int[] nums) {
        String[] s = new String[3];
        for (int i = 0; i < 3; i++) {
            s[i] = Integer.toBinaryString(nums[i]);
        }
        Arrays.sort(s, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder str = new StringBuilder();
        for (String string : s) {
            str.append(string);
        }

        int k = 0;
        while (str.charAt(k) == '0') {
            k++;
        }
        String substring = str.substring(k);
        int len = substring.length();
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            ans += (int) (Math.pow(2, len - i - 1) * (substring.charAt(i) - '0'));
        }

        return ans;
    }
    public static void main(String[] args) {
        MaxGoodNumber t = new MaxGoodNumber();
        t.maxGoodNumber(new int[]{1, 2, 3});
    }
}
