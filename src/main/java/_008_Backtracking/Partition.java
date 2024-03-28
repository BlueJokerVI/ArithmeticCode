package _008_Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/palindrome-partitioning/
 */
public class Partition {

    List<List<String>> ans = new ArrayList<>();
    List<String> path   = new ArrayList<>();


    public List<List<String>> partition(String s) {

        dfs(0,s.length()-1,s);

        return ans;
    }


    /**
     * 递归纵向，for内横向
     * @param l
     * @param r
     * @param s
     */
    void dfs(int l,int r,String s){
        if(l>r){
            ans.add(new ArrayList<>(path));
            return;
        }

        int len = r-l+1;

        //枚举长度
        for (int i=1;i<=len;i++){
            String cur = s.substring(l,l+i);


            //减枝
            if(!isHuiWen(cur)){
                continue;
            }
            path.add(cur);
            dfs(l+i,r,s);
            path.remove(path.size()-1);
        }
    }


    boolean isHuiWen(String s){
        int r = s.length()-1;
        int l = 0;
        while (l<=r){
            int i = s.charAt(r);
            int j = s.charAt(l);
            if(i!=j){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
