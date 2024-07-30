package _009_Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test {
    public List<Integer> partitionLabels(String s) {
        char[] cs = s.toCharArray();
        int[][] cnt = new int[26][2];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            Arrays.fill(cnt[i], -1);
        }

        for (int i = 0; i < cs.length; i++) {
            int index = cs[i] - 'a';
            if (cnt[index][0] == -1) {
                cnt[index][0] = i;
            }
            cnt[index][1] = i;
        }

        int l = cnt[cs[0] - 'a'][0], r = cnt[cs[0] - 'a'][1];
        for (int i = 1; i < cs.length; i++) {
            int index = cs[i] - 'a';
            if (cnt[index][0] > r) {
                ans.add(r - l + 1);
                l = cnt[index][0];
                r = cnt[index][1];
            } else {
                r = Math.max(r,cnt[index][1]);
            }
        }
        ans.add(r - l + 1);
        return ans;
    }
}
