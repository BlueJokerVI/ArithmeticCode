package _004_Str;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-16  21:18
 * @Description: https://leetcode.cn/problems/reverse-string-ii/
 * @Version: 1.0
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        // 1. 每隔 2k 个字符的前 k 个字符进行反转
        for (int i = 0; i< ch.length; i += 2 * k) {
            // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if (i + k <= ch.length) {
                reverseString(ch, i, i + k -1);
                continue;
            }
            // 3. 剩余字符少于 k 个，则将剩余字符全部反转
            reverseString(ch, i, ch.length - 1);
        }
        return  new String(ch);

    }

    public void reverseString(char[] s,int i,int j) {
        while (i<j){
            char tmp = s[j];
            s[j] = s[i];
            s[i] = tmp;
            i++;
            j--;
        }
    }


    @Test
    public void test(){
        this.reverseStr("abcdefg",2);
    }
}
