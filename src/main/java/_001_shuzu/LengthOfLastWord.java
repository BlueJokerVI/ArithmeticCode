package _001_shuzu;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/length-of-last-word/?envType=study-plan-v2&envId=top-interview-150
 */
public class LengthOfLastWord {

    public static final char CHAR = ' ';

    public int lengthOfLastWord(String s) {


        boolean f = false;
        int cnt = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == CHAR) {
            i--;
        }
        for (; i >= 0; i--) {
            if (s.charAt(i) != CHAR) {
                cnt++;
            } else {
                return cnt;
            }
        }
        //不会到这
        return cnt;
    }
}
