package _009_Greedy;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/lemonade-change/
 */
public class LemonadeChange {


    public boolean lemonadeChange(int[] bills) {
        //柠檬水，先用10，再用5

        int[] cnt = new int[21];

        for (int bill : bills) {
            if(bill==5){
                cnt[5] ++;
            }

            if(bill==10){
                if(cnt[5] <=0){
                    return false;
                }
                cnt[10]++;
                cnt[5]--;
            }

            if(bill==20){
                if(cnt[10]>0 && cnt[5]>0){
                    cnt[10]--;
                    cnt[5]--;
                }else if(cnt[5]>=3){
                    cnt[5] -= 3;
                }else {
                    return false;
                }
            }


        }
        return true;
    }
}
