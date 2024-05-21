package _005_towptr;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-window-substring/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        int[] cntT = new int[128];
        int[] cntS = new int[128];
        int ansL = -1;
        int ansR = s.length();

        for (int i = 0; i < t.length(); i++) {
            cntT[t.charAt(i)]++;
        }

        int l = 0, r = 0;
        while (l <= r && r < s.length()) {
            cntS[s.charAt(r)]++;

            while (cover(cntT, cntS)) {
                if (r - l < ansR - ansL) {
                    ansR = r;
                    ansL = l;
                }
                cntS[s.charAt(l)]--;
                l++;
            }
            r++;
        }

        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }


    boolean cover(int[] cntT, int[] cntS) {
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntT[i] > cntS[i]) {
                return false;
            }
        }

        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntT[i] > cntS[i]) {
                return false;
            }
        }

        return true;
    }


    //优化cover
    public String minWindow1(String s, String t) {
        int[] cntT = new int[128];
        int[] cntS = new int[128];
        int ansL = -1;
        int ansR = s.length();

        //diff表示s子串与t串不同字母的数量
        int diff = 0;
        for (int i = 0; i < t.length(); i++) {
            if(cntT[t.charAt(i)]==0){
                //diff初始化为t中不同字符的数目
                diff++;
            }
            cntT[t.charAt(i)]++;
        }

        int l = 0, r = 0;
        while (l <= r && r < s.length()) {
            cntS[s.charAt(r)]++;
            if(cntS[s.charAt(r)]==cntT[s.charAt(r)]){
                diff--; //字串与t串某字符数量相同时，差异减一
            }

            while (diff==0) {
                if (r - l < ansR - ansL) {
                    ansR = r;
                    ansL = l;
                }
                if(cntS[s.charAt(l)]==cntT[s.charAt(l)]){
                    diff++;
                }
                cntS[s.charAt(l)]--;
                l++;
            }
            r++;
        }

        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }



    @Test
    public void test() {
        minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd");
    }
}
