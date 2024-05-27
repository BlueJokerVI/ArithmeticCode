package _006_StackAndQueue;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/basic-calculator/?envType=study-plan-v2&envId=top-interview-150
 */
public class Calculate {
    //中缀表达式转后缀
    public String[] getPrefix(String s) {
        s = s.replace(" ", "");
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = "0" + s;
        }
        s = s.replace("(-", "(0-");
        s = s.replace("(+", "(0+");

        List<String> midFix = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                int r = i;
                while (r < s.length() && s.charAt(r) - '0' >= 0 && s.charAt(r) - '0' <= 9) {
                    r++;
                }
                String num = s.substring(i, r);
                midFix.add(num);
                i = r - 1;
            } else if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    midFix.add(stack.pop().toString());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    midFix.add(stack.pop().toString());
                }
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            midFix.add(stack.pop().toString());
        }
        return midFix.toArray(new String[0]);
    }


    //计算后缀表达式值
    public int evalRPN(String[] tokens) {
        Deque<Integer> s = new ArrayDeque<>();

        for (String token : tokens) {
            if ("+".equals(token)) {
                int b = s.pop();
                int a = s.pop();
                s.push(a + b);
                continue;
            }

            if ("-".equals(token)) {
                int b = s.pop();
                int a = s.pop();
                s.push(a - b);
                continue;
            }

            s.push(new Integer(token));
        }

        return s.peek();
    }


    private Map<Character, Integer> map = new HashMap<>();
    private Deque<Character> opQue = new LinkedList<>();
    private Deque<Integer> numQue = new LinkedList<>();

    private void compute() {
        int b = numQue.pollLast();
        int a = numQue.pollLast();
        int op = opQue.pollLast();
        int ans = 0;
        switch (op) {
            case '+':
                ans = a + b;
                break;
            case '-':
                ans = a - b;
                break;
            case '*':
                ans = a * b;
                break;
            case '/':
                ans = a / b;
                break;
            default:
                break;
        }
        numQue.addLast(ans);
    }

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        map.put('+', 0);
        map.put('-', 0);
        map.put('*', 1);
        map.put('/', 1);
        map.put('(', -1);
        map.put(')', -1);
        numQue.addLast(0);
        char[] sArr = s.toCharArray();
        int n = sArr.length;
        for (int i = 0; i < n; i++) {
            // 截取数字
            if (sArr[i] >= '0' && sArr[i] <= '9') {
                int start = i;
                while (i < n && sArr[i] >= '0' && sArr[i] <= '9') {
                    ++i;
                }
                int num = Integer.parseInt(s.substring(start, i));
                numQue.addLast(num);
            }
            if (i >= n) {
                break;
            }
            if (sArr[i] == '(') {
                opQue.addLast(sArr[i]);
            } else if (sArr[i] == ')') {
                while (opQue.peekLast() != '(') {
                    compute();
                }
                opQue.pollLast();
            } else {
                // 判断是否出现了(- 或者 (+这种情况,那么进行操作数栈补0
                if (i > 0 && sArr[i - 1] == '(') {
                    numQue.addLast(0);
                }
                while (!opQue.isEmpty() && map.get(opQue.peekLast()) >= map.get(sArr[i])) {
                    compute();
                }
                opQue.addLast(sArr[i]);
            }
        }

        while (!opQue.isEmpty()) {
            compute();
        }
        return numQue.peekLast();
    }


    @Test
    public void test1() {
        int calculate = calculate("1*4*6/6+1");
        System.out.println();
    }


    @Test
    public void test() {
        //0 1 + 0 2 - -     1 0 2 - -    1 -2 -   3
        String[] prefix = getPrefix("-2+ 1");
        int i = evalRPN(prefix);
        System.out.println(i);
    }

}
