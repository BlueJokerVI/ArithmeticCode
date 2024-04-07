package _009_Greedy;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/candy/
 */
public class Candy {
    public int candy(int[] ratings) {
        List<Pair<Integer, Integer>> valueToIndex = new ArrayList<>();

        //curCnt[i]记录i节点分得的糖果数
        int[] curCnt = new int[ratings.length];

        for (int i = 0; i < ratings.length; i++) {
            curCnt[i] = 1;
            Pair<Integer, Integer> pair = new Pair<>(ratings[i], i);
            valueToIndex.add(pair);
        }
        valueToIndex.sort(Comparator.comparingInt(Pair::getKey));


        /**
         * 从最小的rating开始遍历，每次校验其与相另两边值的关系
         * 1.诺两边rating[l or r]大于rating[index]
         * 2.curCnt[l or r] <= curCnt[index]
         * 就更新两边的curCnt[l or r] = curCnt[index] + 1;
         */

        int ans = ratings.length;
        for (int i = 0; i < valueToIndex.size(); i++) {
            int index = valueToIndex.get(i).getValue();
            int l = index - 1;
            int r = index + 1;

            if (r < ratings.length && ratings[r] > ratings[index] && curCnt[r] <= curCnt[index]) {
                ans -= curCnt[r];
                curCnt[r] = curCnt[index] + 1;
                ans += curCnt[r];
            }

            if (l >= 0 && ratings[l] > ratings[index] && curCnt[l] <= curCnt[index]) {
                ans -= curCnt[l];
                curCnt[l] = curCnt[index] + 1;
                ans += curCnt[l];
            }
        }

        return ans;
    }


    public int candy1(int[] ratings) {
        //1.从左往右遍历一次，保证rating[r] > rating[index] 的 curCnt[r] > curCnt[index]
        //2.从右往左遍历，保证rating[l] > rating[index] 的 curCnt[l] > curCnt[index]
        int[] curCnt = new int[ratings.length];
        Arrays.fill(curCnt, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                curCnt[i] = curCnt[i - 1] + 1;
            }
        }


        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                //ratings[i] > ratings[i + 1]  &&  curCnt[i] < curCnt[i + 1] + 1  才修改curCnt[i]的值
                curCnt[i] = Math.max(curCnt[i], curCnt[i + 1] + 1);
            }
        }

        int ans = 0;
        for (int i : curCnt) {
            ans += i;
        }

        return ans;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 0, 2};
        candy(nums);
    }
}
