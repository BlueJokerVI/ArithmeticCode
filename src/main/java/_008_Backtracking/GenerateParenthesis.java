package _008_Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/generate-parentheses/?envType=study-plan-v2&envId=top-interview-150
 */
public class GenerateParenthesis {

    int n;
    List<String> ans = new ArrayList<>();
    StringBuilder cur = new StringBuilder();

    //统计左括号数
    int cntL;
    int cntR;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(1);
        return ans;
    }


    void dfs(int index){

        if(index==2*n+1){
            ans.add(cur.toString());
            return;
        }


        if(cntL < n){
            cur.append('(');
            cntL++;
            dfs(index+1);
            cur.setLength(cur.length()-1);
            cntL--;
        }

        if(cntL - cntR > 0){
            cntR ++;
            cur.append(')');
            dfs(index+1);
            cur.setLength(cur.length()-1);
            cntR--;
        }


    }

}
