package _005_towptr;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/is-subsequence/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            boolean f = false;
            for(int j = index; j<t.length();j++){
                char c2 = t.charAt(j);
                if(c1==c2){
                    index  = j+1;
                    f = true;
                    break;
                }
            }
            if(!f){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        isSubsequence("axc","ahbgdc");
    }
}
