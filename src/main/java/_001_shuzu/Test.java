package _001_shuzu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 1) {
            return intervals;
        }


        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> ans = new LinkedList<>();
        int l = intervals[0][0];
        int r = intervals[0][1];
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            if (r < intervals[i][0]) {
                ans.add(new int[]{l, r});
                l = intervals[i][0];
                r = intervals[i][1];
            } else {
                r = Math.max(r, intervals[i][1]);
            }
            if (i == n - 1) {
                ans.add(new int[]{l, r});
            }
        }

        return ans.toArray(new int[0][]);

    }


    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (cur > ans) {
                ans = cur;
            }
            if (cur < 0) {
                cur = 0;
            }
        }
        return ans;
    }


    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = 0;
        for (int start = 0; start < k; ++start) {
            int cur = start;
            int preValue = nums[start];
            int next = (start+k)%n;
            while (next!=cur){
                int tmp = nums[next];
                nums[next] = preValue;
                count++;
                if(count==n){
                    return;
                }
                preValue = tmp;
                next = (next + k)%n;
            }
            nums[cur] = preValue;
            count++;
            if(count==n){
                return;
            }
        }
    }
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[n-1] = nums[n-1];
        for (int i = n-2; i >=0 ; i--) {
           ans[i] = ans[i+1]*nums[i];
        }

        int l = 1;
        for (int i = 0; i < n-1; i++) {
            ans[i] = l*ans[i+1];
            l *= nums[i];
        }
        ans[n-1] = l;
        return ans;
    }

    public int singleNumber(int[] nums) {
        long ans = 0;
        boolean[] vis = new boolean[60001];
        for (int num : nums) {
            ans += vis[num+30000] ? -num : num;
            vis[num+30000] = !vis[num+30000];
        }

        return (int)ans;
    }
}
