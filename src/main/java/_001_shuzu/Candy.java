package _001_shuzu;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/candy/?envType=study-plan-v2&envId=top-interview-150
 */
public class Candy {
    public int candy(int[] ratings) {
        List<Pair<Integer,Integer>> list = new ArrayList<>();
        int[] cnt = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            Pair<Integer, Integer> pair = new Pair<Integer, Integer>(ratings[i],i);
            list.add(pair);
        }
        list.sort(Comparator.comparingInt(Pair::getKey));

        for (int i = 0; i < list.size(); i++) {
            Pair<Integer, Integer> pair = list.get(i);
            int v = pair.getKey();
            int index = pair.getValue();

            if(index+1<ratings.length && v<ratings[index+1]){
                cnt[index+1] = Math.max(cnt[index] + 1,cnt[index+1]);
            }
            if(index-1>=0 && v < ratings[index-1]){
                cnt[index-1] = Math.max(cnt[index] + 1,cnt[index-1]);
            }
        }

        int ans = ratings.length;
        for (int i : cnt) {
            ans+=i;
        }
        return ans;
    }

    public int candy1(int[] ratings) {
        int[] cnt = new int[ratings.length];

        cnt[0] = 1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                cnt[i] = cnt[i-1] + 1;
            }else {
                cnt[i] = 1;
            }
        }

        for(int i=ratings.length-2;i>=0;i++){
            if(ratings[i] > ratings[i+1]){
                cnt[i] = Math.max(cnt[i],cnt[i+1]+1);
            }
        }

        int ans = 0;
        for (int i : cnt) {
            ans+=i;
        }
        return ans;
    }
}


// dp[i] = min(dp[i-1],dp[i+1]) + 1;

/**
 * 0,1,2,3,2,1
 *   1 2 3 1
 *
 *
 * 0 1 1 2 2 3
 *
 *
 */
