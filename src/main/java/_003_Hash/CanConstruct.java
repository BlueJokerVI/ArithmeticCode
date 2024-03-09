package _003_Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-09  21:40
 * @Description: https://leetcode.cn/problems/ransom-note/      383. 赎金信
 * @Version: 1.0
 */
public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            cnt.put(c,cnt.getOrDefault(c,0)+1);
        }


        for(char c : ransomNote.toCharArray()){
           int v =  cnt.getOrDefault(c,0) - 1;
           if(v<0){
               return false;
           }

           cnt.put(c,v);
        }

        return true;
    }

}
