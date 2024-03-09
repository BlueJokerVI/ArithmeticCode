package _004_Str;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-18  19:17
 * @Description: https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * 28. 找出字符串中第一个匹配项的下标
 * @Version: 1.0
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        int len1 = needle.length();
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();

        int f = -1;

        for (int i = 0; i < len - len1 + 1; i++) {

            for (int j = 0; j < len1; j++) {
                if (n[j] != h[i + j]) {
                    break;
                }

                if (j == len1 - 1) {
                    f = i;
                    return f;
                }
            }
        }

        return f;
    }


    /**
     * KMP 算法
     * @param s
     * @param d
     * https://www.zhihu.com/question/21923021/answer/281346746
     * @return
     */
    public int KMP(String s, String d) {

        //s,文本串   d,目标串
        int dLen = d.length();
        int sLen = s.length();
        int[] next = new int[dLen+1];
        getNext(next,d);
        int i = 0;
        int j = 0;

        while (i < sLen && j < dLen)
        {
            if (j == -1 || s.charAt(i) == d.charAt(j))
            {
                i++;
                j++;
            }
            else
                j = next[j];
        }

        if (j == dLen)
            return i - j;
        else
            return -1;
    }

    private void getNext(int[] next, String s) {

        //next[i]  表示0~i-1字串的最长相同前后缀
        next[0] = -1;
        int i = 0, j = -1;
        int sLen = s.length();
        // j < i

        //寻找0~i字串的最长前后缀
        while (i < sLen-1)
        {
            if (j == -1 || s.charAt(i) == s.charAt(j))
            {
                ++i;
                ++j;
                next[i] = j;
            }
            else
                j = next[j];
        }

    }


}
