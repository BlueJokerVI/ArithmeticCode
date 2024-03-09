package _006_StackAndQueue;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;



/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-28  09:24
 * @Description: https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * 150. 逆波兰表达式求值
 * @Version: 1.0
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        int len  = tokens.length;
        Deque<String > s = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            Integer a,b;

            if("+".equals(tokens[i])){
                a = Integer.parseInt(s.pollLast()) ;
                b = Integer.parseInt(s.pollLast());
                s.offerLast(a+b+"");
                continue;
            }

            if("-".equals(tokens[i])){
                a = Integer.parseInt(s.pollLast()) ;
                b = Integer.parseInt(s.pollLast());
                s.offerLast(b-a+"");
                continue;
            }

            if("*".equals(tokens[i])){
                a = Integer.parseInt(s.pollLast()) ;
                b = Integer.parseInt(s.pollLast());
                s.offerLast(a*b+"");
                continue;
            }

            if("/".equals(tokens[i])){
                a = Integer.parseInt(s.pollLast()) ;
                b = Integer.parseInt(s.pollLast());
                s.offerLast(b/a+"");
                continue;
            }


            s.offerLast(tokens[i]);
        }
        return Integer.parseInt(s.peekLast());
    }


    @Test
    public void test(){
        this.evalRPN(new String[]{"2","1","+","3","*"});
    }
}
