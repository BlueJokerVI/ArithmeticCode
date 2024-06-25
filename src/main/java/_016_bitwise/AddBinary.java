package _016_bitwise;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/add-binary/?envType=study-plan-v2&envId=top-interview-150
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int l = a.length()-1;
        int r = b.length()-1;
        int tmp=0;
        StringBuilder ans = new StringBuilder();
        while (l>=0 && r>=0){
            int cA = a.charAt(l) - '0';
            int cB = b.charAt(r) - '0';
            int v = cA + cB + tmp;

            int cur = v % 2;
            tmp = v/2;
            ans.append(cur);
            l--;
            r--;
        }

        while (l>=0){
            int cA = a.charAt(l) - '0';
            int v = cA + tmp;
            int cur = v % 2;
            tmp = v/2;
            ans.append(cur);
            l--;
        }

        while (r>=0){
            int cB = b.charAt(r) - '0';
            int v = cB + tmp;
            int cur = v % 2;
            tmp = v/2;
            ans.append(cur);
            r--;
        }

        if(tmp!=0){
            ans.append(tmp);
        }

        return ans.reverse().toString();
    }
}
