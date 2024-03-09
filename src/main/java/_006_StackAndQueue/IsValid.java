package _006_StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-27  20:24
 * @Description: https://leetcode.cn/problems/valid-parentheses/
 * 20. 有效的括号
 * @Version: 1.0
 */
public class IsValid {
    public boolean isValid(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        if(len%2==1){
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < chs.length; i++) {

            if(chs[i]=='('||chs[i]=='{'||chs[i]=='['){
                stack.offerLast(chs[i]);
            }else {
                char c = chs[i];
                char b = stack.peekLast();
                if(c==')'||b=='('){
                    stack.pollLast();
                    continue;
                }

                if(c=='}'||b=='{'){
                    stack.pollLast();
                    continue;
                }

                if(c==']'||b=='['){
                    stack.pollLast();
                    continue;
                }

                return false;
            }
        }

        return stack.isEmpty();

    }
}
