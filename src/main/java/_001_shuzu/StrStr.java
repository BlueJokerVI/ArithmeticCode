package _001_shuzu;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/?envType=study-plan-v2&envId=top-interview-150
 */
public class StrStr {
    public int strStr(String haystack, String needle) {

        char start = needle.charAt(0);
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            if(haystack.charAt(i)==start){
                String substring = haystack.substring(i, i + needle.length());
                if(substring.equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}
