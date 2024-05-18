package _001_shuzu;

import java.util.HashMap;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/integer-to-roman/?envType=study-plan-v2&envId=top-interview-150
 */
public class IntToRoman {
    public String intToRoman(int num) {
        int v = num/1000;
        num%=1000;
        StringBuilder ans= new StringBuilder();
        while (v>0){
            ans.append("M");
            v--;
        }

        v = num/100;
        num%=100;
        if(v==4){
            ans.append("CD");
        }else if(v==9){
            ans.append("CM");
        }else {
            if(v >= 5){
                ans.append("D");
                v-=5;
            }
            while (v > 0){
                ans.append("C");
                v--;
            }
        }

        v = num/10;
        if(v==4){
            ans.append("XL");
        }else if(v==9){
            ans.append("XC");
        }else {
            if(v >= 5){
                ans.append("L");
                v-=5;
            }
            while (v > 0){
                ans.append("X");
                v--;
            }
        }

        v = num%10;
        if(v==4){
            ans.append("IV");
        }else if(v==9){
            ans.append("IX");
        }else {
            if(v >= 5){
                ans.append("V");
                v-=5;
            }
            while (v > 0){
                ans.append("I");
                v--;
            }
        }

        return ans.toString();
    }
}
