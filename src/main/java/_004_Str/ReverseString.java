package _004_Str;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-16  21:14
 * @Description: https://leetcode.cn/problems/reverse-string/description/
 * @Version: 1.0
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int j = s.length-1;
        int i = 0;

        while (i<j){
            char tmp = s[j];
            s[j] = s[i];
            s[i] = tmp;
            i++;
            j--;
        }

    }
}
