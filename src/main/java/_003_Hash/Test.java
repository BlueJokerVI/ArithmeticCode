package _003_Hash;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            cnt[magazine.charAt(i)-'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            cnt[ransomNote.charAt(i)-'a']--;
            if(cnt[ransomNote.charAt(i)-'a'] < 0){
                return false;
            }
        }

        return true;
    }


    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            cnt[t.charAt(i)-'a']--;
            if(cnt[t.charAt(i)-'a'] < 0){
                return false;
            }
        }
        return true;
    }


}
