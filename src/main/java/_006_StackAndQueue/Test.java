package _006_StackAndQueue;

import org.apache.commons.codec.binary.StringUtils;
import org.jsoup.internal.StringUtil;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test {

    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(' || s.charAt(i)== '{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
                continue;
            }

            char top = '-';
            if(!stack.isEmpty()){
                top = stack.pop();
            }

            if(s.charAt(i)=='}'){
                if(top!='{'){
                    return false;
                }
            }

            if(s.charAt(i)==')'){
                if(top!='('){
                    return false;
                }
            }


            if(s.charAt(i)==']'){
                if(top!='['){
                    return false;
                }
            }
        }

        return stack.size()==0;
    }


    public int evalRPN(String[] tokens) {
        Deque<Integer> s =  new ArrayDeque<>();

        for (String token : tokens) {
            if("+".equals(token)){
                int b = s.pop();
                int a = s.pop();
                s.push(a+b);
                continue;
            }

            if("-".equals(token)){
                int b = s.pop();
                int a = s.pop();
                s.push(a-b);
                continue;
            }

            if("*".equals(token)){
                int b = s.pop();
                int a = s.pop();
                s.push(a*b);
                continue;
            }

            if("/".equals(token)){
                int b = s.pop();
                int a = s.pop();
                s.push(a/b);
                continue;
            }

            s.push(new Integer(token));
        }

        return s.peek();
    }




    @org.junit.Test
    public void test(){
        isValid("()[]{}");
    }
}
