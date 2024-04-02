package _009_Greedy;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/assign-cookies/
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        int index = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while (ans<g.length && index<s.length){
            if(s[index] >= g[ans]){
                ans++;
            }
            index++;
        }

        return ans;
    }
}
