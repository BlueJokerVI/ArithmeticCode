package _005_towptr;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;

        if(s.length()==1){
            return true;
        }

        while (l<r){
            char c1='.';
            char c2='.';
            while (l<=r && '.'== (c1=getC(s.charAt(l) ))){
                l++;
            }

            //全是要去除的字符
            if(c1=='.'){
                return true;
            }

            while (l<=r && '.'==(c2=getC(s.charAt(r) ))){
                r--;
            }

            if(c1!=c2){
                return false;
            }else {
                l++;
                r--;
            }
        }

        return true;
    }


    char getC(char c){

        if((c>='a' && c<='z')||(c>='0' && c<='9')){
            return c;
        }
        if(c>='A' && c<='Z'){
            return (char)(c - 'A' + 'a');
        }
        return '.';
    }


    @Test
    public void test(){
        isPalindrome("a.");
        System.out.println();
    }

}
