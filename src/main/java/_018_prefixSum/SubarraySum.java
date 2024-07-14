package _018_prefixSum;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/subarray-sum-equals-k/?envType=study-plan-v2&envId=top-100-liked
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        //相当于求在[0,n-1]内 prefix[j] - prefix[i] = k 出现的次数
        //prefix[i] = prefix[j] - k
        //cnt记录[k,v] k出现的次数
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int j = 0; j <=n; j++) {
            ans += cnt.getOrDefault(prefix[j]-k,0);
            cnt.put(prefix[j],cnt.getOrDefault(prefix[j],0)+1);
        }

        return ans;
    }

    @Test
    public void test() {
        subarraySum(new int[]{-1, -1, 1}, 1);
    }
}
