package _006_StackAndQueue;


import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/simplify-path/?envType=study-plan-v2&envId=top-interview-150
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        StringBuilder ans = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        String[] split = path.split("/");
        for (String s : split) {
            if ("".equals(s) || ".".equals(s)) {
                continue;
            }
            if ("..".equals(s)) {
                if(!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            }
            stack.push("/"+s);
        }

        while (!stack.isEmpty()){
            ans.append(stack.getLast());
            stack.removeLast();
        }

        if(ans.length()==0){
            ans.append("/");
        }
        return ans.toString();
    }


    @Test
    public void test() {
       simplifyPath("/../");
    }

}
