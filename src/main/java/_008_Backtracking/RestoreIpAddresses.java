package _008_Backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/restore-ip-addresses/
 */
public class RestoreIpAddresses {
    List<String> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(0,s);
        return ans;
    }


    //还是切割问题，纵向递归，横向遍历每层的可能性
    void dfs(int index, String s) {
        if (path.size() == 4) {


            StringBuffer st = new StringBuffer();
            for (int i = 0; i < path.size(); i++) {
                st.append(path.get(i));
                if (i != path.size() - 1) {
                    st.append(".");
                }
            }

            ans.add(st.toString());
            return;
        }

        String tmp;
        //枚举长度
        int len = s.length() - index;
        for (int i = 1; i <= len && i <= 3; i++) {
            tmp = s.substring(index, index + i);

            if (!isValid(tmp)) {
                continue;
            }

            //ip地址最多4个数字
            if(path.size()==3 && index+i != s.length()){
                continue;
            }

            path.add(tmp);
            dfs(i, s);
            path.remove(path.size() - 1);
        }
    }


    boolean isValid(String tmp) {

        int len = tmp.length();

        if("0".equals(tmp)){
            return true;
        }

        if(tmp.charAt(0)=='0'&&len!=1){
            return false;
        }


        int v = 0;
        for (int i = len-1; i >= 0; i--) {
            int c  = tmp.charAt(i)-'0';
            if(c<0||c>9){
                return false;
            }

            v += c*Math.pow(10,len-i-1);
        }

        if(v>0&&v<=255){
            return true;
        }

        return false;
    }


    @Test
    public void test(){
        System.out.println(isValid("255"));
    }
}
