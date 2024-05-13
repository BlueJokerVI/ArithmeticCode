package _001_shuzu;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/h-index/?envType=study-plan-v2&envId=top-interview-150
 */
public class HIndex {

    //排序枚举
    public int hIndex(int[] citations) {
        int h = citations.length;
        Arrays.sort(citations);
        for(int i=h;i>=1;i--){
            int index = citations.length - i;
            if(citations[index] >= i ){
                return i;
            }
        }
        return 0;
    }


    public int hIndex1(int[] citations) {

        //cnt记录citations[i]出现次数，且如果citations[i]大于citations.length按其等于citations.length计算
        int n  = citations.length;
        int[] cnt = new int[n+1];
        for (int c : citations) {
            cnt[Math.min(c,n)]++;
        }

        int s=0;
        //逆序遍历，统计大于h次引用出现的次数
        for(int h=n;h>=0;h--){
            s+=cnt[h];
            if(s>=h){
                return h;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        hIndex(new int[] {3,0,6,1,5});
    }

}
