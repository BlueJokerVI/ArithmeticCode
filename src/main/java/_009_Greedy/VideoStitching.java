package _009_Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cct
 * https://leetcode.cn/problems/video-stitching/
 */
public class VideoStitching {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, Comparator.comparingInt(a -> a[0]));
        if (clips[0][0] != 0) {
            return -1;
        }

        int l;
        int mv = Integer.MIN_VALUE;
        int idx = 0;
        int n = clips.length;
        int ans = 1;
        while (idx < n && clips[idx][0] == 0) {
            mv = Math.max(mv, clips[idx][1]);
            idx++;
        }
        l = mv;
        if(mv >= time){
            return ans;
        }

        while (idx < n) {
            while (idx < n && clips[idx][0] <= l) {
                mv = Math.max(mv, clips[idx][1]);
                idx++;
            }
            if (l != mv){
                ans++;
                if(mv >= time){
                    return ans;
                }
            }
            else{
                break;
            }
            l = mv;
        }
        return -1;
    }
}
