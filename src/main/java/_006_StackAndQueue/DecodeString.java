package _006_StackAndQueue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class DecodeString {
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] cs = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (char c : cs) {
            if (c != ']') {
                stack.push(c);
            } else {
                StringBuilder tmp = new StringBuilder();
                char cur = stack.pop();
                while (cur != '[') {
                    tmp.append(cur);
                    cur = stack.pop();
                }
                tmp.reverse();

                StringBuilder digit = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())){
                    digit.append(stack.pop());
                }
                digit.reverse();
                int cnt = Integer.parseInt(digit.toString());

                String addStr = tmp.toString();
                while (cnt > 1) {
                    tmp.append(addStr);
                    cnt--;
                }
                String s1 = tmp.toString();
                for (int j = 0; j < s1.length(); j++) {
                    stack.push(s1.charAt(j));
                }
            }
        }

        while (!stack.isEmpty()){
            ans.append(stack.pop());
        }
        ans.reverse();

        return ans.toString();
    }

    class Solution {
        public String decodeString(String s) {
            StringBuilder res = new StringBuilder();
            int multi = 0;
            LinkedList<Integer> stack_multi = new LinkedList<>();
            LinkedList<String> stack_res = new LinkedList<>();
            for(Character c : s.toCharArray()) {
                if(c == '[') {
                    stack_multi.addLast(multi);
                    stack_res.addLast(res.toString());
                    multi = 0;
                    res = new StringBuilder();
                }
                else if(c == ']') {
                    StringBuilder tmp = new StringBuilder();
                    int cur_multi = stack_multi.removeLast();
                    for(int i = 0; i < cur_multi; i++) tmp.append(res);
                    res = new StringBuilder(stack_res.removeLast() + tmp);
                }
                else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
                else res.append(c);
            }
            return res.toString();
        }
    }

    @Test
    public void test(){
        decodeString("100[leetcode]");
    }

}
