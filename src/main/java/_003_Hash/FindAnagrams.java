package _003_Hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-10  22:55
 * @Description: https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 * @Version: 1.0
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (p.length()==0){
            int len =  s.length();
            for (int i = 0; i < len; i++) {
                ans.add(i);
            }
            return ans;
        }

        int[] cnt = new int[26];

        //mp[i+1]记录下标为0~i的字串字母出现情况   故下表i~j出现的情况可有mp[j]、mp[i]的状态算出
        int[][] mp = new int[s.length()+1][26];

        for (char c : p.toCharArray()) {
            cnt[c-'a']++;
        }



        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i-1);

            for(int j=0;j<26;j++){
                mp[i][j] = mp[i-1][j];
            }
            mp[i][c-'a']++;
        }

        int len = p.length();

        int[] find = new int[26];


        for(int i=1;i<=s.length()-len+1;i++){
//            i i+len-1   0   3
//                0   2

            int f = 0;
            for(int j=0;j<26 ;j++){
                find[j] = mp[i+len-1][j] - mp[i-1][j];
                if(find[j]!=cnt[j]){
                    f = 1;
                    break;
                }
            }

            if(f==0){
                ans.add(i-1);
            }
        }
        return ans;
    }


    @Test

    public  void test(){
        this.findAnagrams("cbaebabacd","abc");
    }

}
