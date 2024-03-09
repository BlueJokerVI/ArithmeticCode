package _004_Str;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-18  21:18
 * @Description: https://leetcode.cn/problems/repeated-substring-pattern/
 * 459. 重复的子字符串
 * @Version: 1.0
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int cnt = s.length()/2;
        int len = s.length();
        //枚举字串长度
        for (int i = cnt; i >=1  ; i--) {
            if(len%i==0){
                String substr = s.substring(0,i);
                int f1 = 0;
                for (int j = i; j < len; j=j+i) {
                    if(!substr.equals(s.substring(j, j + i))){
                        f1 = 1;
                        break;
                    }
                }

                if(f1==0){
                    return true;
                }
            }
        }

        return false;
    }

    @Test
    public void test(){
        this.repeatedSubstringPattern("ababab");
    }
}
