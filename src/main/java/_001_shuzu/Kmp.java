package _001_shuzu;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description:  KMP 参考链接 https://blog.csdn.net/weixin_46007276/article/details/104372119?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522171637995416800225568736%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=171637995416800225568736&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~top_positive~default-1-104372119-null-null.nonecase&utm_term=kmp%E7%AE%97%E6%B3%95&spm=1018.2226.3001.4450
 */
public class Kmp {

    /**
     * 返回str的next数组
     *
     * @param str
     * @return
     */
    int[] getNext(String str) {

        //next[i] 表示[0,i-1]子串的最长相同前后缀
        int[] next = new int[str.length()];
        char[] chars = str.toCharArray();
        //第一个字符没有前后缀标记为-1
        next[0] = -1;
        //pre指向前缀的后一个字符，later指向后缀的后一个字符
        int pre = -1, later = 0;

        //later最大为str.length()-1，且next[later]赋值在later++之后，所以later < str.length()-1
        while (later < str.length() - 1) {
            //相同前后缀的后一个字符相同
            if (pre == -1 || chars[pre] == chars[later]) {
                pre++;
                later++;
                next[later] = pre;
            } else {
                //相同前后缀的后一个字符不相同，则要比较更短前缀是否相同，具体可以看上面链接
                pre = next[pre];
            }
        }
        return next;
    }

    /**
     * kmp 算法，判断t是否是s的子串
     * @param s
     * @param t
     * @return
     */
    int KMP(String s, String t) {

        int[] next = getNextVal(t);
        int i=0,j=0;
        while (i<s.length() && j<t.length()){
            if(j==-1 || s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }

        if(j>=t.length()){
            //是子串，返回t中起始下标
            return i-t.length();
        }else {
            //不是子串返回-1
            return -1;
        }
    }


    /**
     * next数组优化
     * @param str
     * @return
     */
    int[] getNextVal(String str){
        //next[i] 表示[0,i-1]子串的最长相同前后缀
        int[] nextVal = new int[str.length()];
        char[] chars = str.toCharArray();
        nextVal[0] = -1;
        int pre = -1, later = 0;

        //later最大为str.length()-1，且next[later]赋值在later++之后，所以later < str.length()-1
        while (later < str.length() - 1) {
            //相同前后缀的后一个字符相同
            if (pre == -1 || chars[pre] == chars[later]) {
                pre++;
                later++;
                //str.charAt(later)值为later处值不匹配时会比较的值
                if(str.charAt(later)!=str.charAt(pre)){
                    nextVal[later] = pre;
                }else {
                    nextVal[later] = nextVal[pre];
                }
            } else {
                //相同前后缀的后一个字符不相同，则要比较更短前缀是否相同，具体可以看上面链接
                pre = nextVal[pre];
            }
        }
        return nextVal;
    }


    @Test
    public void test(){
        KMP("ababcababd","ababd");
    }

}
