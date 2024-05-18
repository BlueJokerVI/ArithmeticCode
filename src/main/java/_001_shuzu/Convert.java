package _001_shuzu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/zigzag-conversion/?envType=study-plan-v2&envId=top-interview-150
 */
public class Convert {

    public String convert(String s, int numRows) {


        if(numRows==1){
            return s;
        }

        List<StringBuilder> ans =  new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ans.add(new StringBuilder());
        }


        int index = 0;
        while (index<s.length()){

            for (int i = 0;index<s.length() && i < numRows; i++) {
                ans.get(i).append(s.charAt(index++));
            }
            if(index==s.length()){
                break;
            }
            for (int i = numRows-2;index<s.length() && i>=1; i--) {
                ans.get(i).append(s.charAt(index++));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder an : ans) {
            stringBuilder.append(an);
        }

        return stringBuilder.toString();
    }


    @Test
    public void test(){
        convert("PAYPALISHIRING",3);
    }


}
