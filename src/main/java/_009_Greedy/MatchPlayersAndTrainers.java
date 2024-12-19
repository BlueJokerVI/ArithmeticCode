package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-matching-of-players-with-trainers/
 */
public class MatchPlayersAndTrainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int p = 0;
        int t = 0;
        int n = players.length;
        int m = trainers.length;

        int ans = 0;
        while (p < n && t < m) {
            while (t < m && trainers[t] < players[p]) {
                t++;
            }
            if (t < m) {
                ans++;
                p++;
                t++;
            }
        }
        return ans;
    }
}
