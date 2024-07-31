package _010_dp;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/longest-valid-parentheses/?envType=study-plan-v2&envId=top-100-liked
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {

        char[] cs = s.toCharArray();

        int n = cs.length;
        if (n == 0) {
            return 0;
        }
        //dp[i]表示以i结尾的合法括号最大长度
        int[] dp = new int[n];

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (cs[i] == ')') {
                if (cs[i - 1] == ')') {
                    if (i - dp[i - 1] - 1 >= 0 && cs[i - dp[i - 1] - 1] == '(') {
                        dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                } else if (cs[i - 1] == '(') {
                    dp[i] = (i - 2 > 0 ? dp[i - 2] : 0) + 2;
                }
            }

            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        return ans;
    }


    class Solution {
        public int longestValidParentheses(String s) {
            int maxans = 0;
            Deque<Integer> stack = new LinkedList<Integer>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        maxans = Math.max(maxans, i - stack.peek());
                    }
                }
            }
            return maxans;
        }
    }
    @Test
    public void test() {
        longestValidParentheses(")()())");
    }
}
