package _001_shuzu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/text-justification/?envType=study-plan-v2&envId=top-interview-150
 */
public class FullJustify {


    private List<String > ans = new ArrayList<>();
    public List<String> fullJustify(String[] words, int maxWidth) {
        StringBuilder str = new StringBuilder();
        for (String word : words) {
            if(word.length() == maxWidth){
                if(str.length()!=0){
                    addAns(maxWidth, str);
                    str.setLength(0);
                }
                ans.add(word);
                continue;
            }

            if(str.length()==0){
                str.append(word);
            }else if(str.length() + word.length() + 1 <= maxWidth){
                str.append(" ");
                str.append(word);
            }else {
                addAns(maxWidth,str);
                str.setLength(0);
                str.append(word);
            }
        }

        if(str.length()!=0){
            addAnsWithSpace(maxWidth, str);
        }

        return ans;
    }

    private void addAnsWithSpace(int maxWidth, StringBuilder str) {
        int t = maxWidth - str.length();
        while (t>0){
            str.append(" ");
            t--;
        }
        ans.add(str.toString());
    }

    private void addAns(int maxWidth, StringBuilder str) {
        String[] s = str.toString().split(" ");
        if(s.length==1){
            addAnsWithSpace(maxWidth,str);
            return;
        }

        int charLen = str.length() - s.length + 1;
        int spaceLen = maxWidth - charLen;

        int m = spaceLen % (s.length-1);
        int n = spaceLen / (s.length-1);
        int t = s.length - 1;

        StringBuilder tmp = new StringBuilder();
        for (String s1 : s) {
            tmp.append(s1);
            if(t>0){
                for (int i = 0; i < n; i++) {
                    tmp.append(" ");
                }
                if(m>0){
                    tmp.append(" ");
                    m--;
                }
                t--;
            }
        }
        ans.add(tmp.toString());
    }


    @Test
    public void test(){
        fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"},20);
    }
}
