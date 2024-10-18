package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */
public class MaxVowels {

    private boolean isVowels(char[] chars ,int i){
        return chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u';
    }
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int l = 0, r = 0, cur = 0, max = 0;
        for (int i = 0; i < n; i++) {
            r = i;

            if (isVowels(chars,i)) {
                cur++;
            }

            if (r - l + 1 == k + 1) {
                if (isVowels(chars,l)) {
                    cur--;
                }
                l++;
            }

            if(cur > max){
                max = cur;
            }
        }
        return max;
    }


}
