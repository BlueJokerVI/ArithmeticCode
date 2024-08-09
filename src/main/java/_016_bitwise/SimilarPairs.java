package _016_bitwise;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class SimilarPairs {


    //构造hash
    public int similarPairs(String[] words) {
        HashMap<String,Integer> mp = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            char[] cs = words[i].toCharArray();
            boolean[] ch = new boolean[26];
            for (char c : cs) {
                ch[c-'a'] = true;
            }
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if(ch[j]){
                    s.append(j);
                }
            }
            String key = s.toString();
            mp.put(key,mp.getOrDefault(key,0)+1);
        }

        final int[] ans = {0};
        mp.forEach((k,v)->{
            if(v>1){
                ans[0] += (v*(v-1))/2;
            }
        });
        return ans[0];
    }


    //哈希表+位运算
    public int similarPairs1(String[] words) {
        Map<Integer,Integer> cnt = new HashMap<>();
        int ans = 0;


        for (String word : words) {
            char[] cs = word.toCharArray();
            //可以用26个bit表示key
            int key = 0;
            for (char c : cs) {
                key |= 1 << c - 'a';
            }
            ans += cnt.getOrDefault(key,0);
            cnt.put(key,cnt.getOrDefault(key,0)+1);
        }

        return ans;
    }

    @Test
    public void test(){
        similarPairs1(new String[]{"aba","aabb","abcd","bac","aabc"});
    }
}
