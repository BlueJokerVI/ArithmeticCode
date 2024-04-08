package _009_Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/partition-labels/
 */
public class PartitionLabels {

    int[] cnt = new int[26];
    public List<Integer> partitionLabels1(String s) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cnt[ch-'a'] ++;
        }

        StringBuffer str = new StringBuffer();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            str.append(ch);
            cnt[ch-'a']--;
            if(isSub(str)){
                ans.add(str.length());
                str = new StringBuffer();
            }
        }

        return ans;
    }

    boolean isSub(StringBuffer stringBuffer){
        for (int i = 0; i < stringBuffer.length(); i++) {
            char ch = stringBuffer.charAt(i);
            if(cnt[ch-'a']!=0){
                return false;
            }
        }
        return true;
    }



    public List<Integer> partitionLabels(String s){
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //此处cnt[i] 记录某字母最后出现的位置
            cnt[ch-'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int L = Integer.MIN_VALUE;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int v = cnt[ch - 'a'];
            if(v>L){
                L = v;
            }

            if(L==i){
                ans.add(i-start+1);
                start++;
            }
        }
        return ans;
    }

}
