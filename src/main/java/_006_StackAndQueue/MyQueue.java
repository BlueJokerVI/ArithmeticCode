package _006_StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-25  19:04
 * @Description: https://leetcode.cn/problems/implement-queue-using-stacks/
 * 232. 用栈实现队列
 * @Version: 1.0
 */
public class MyQueue {

    private Deque<Integer> stack1;

    private Deque<Integer> stack2;


    public MyQueue() {
        stack1 = new ArrayDeque<Integer>();
        stack2 = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(!stack2.isEmpty()){
           return stack2.pollLast();
        }else if (!stack1.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pollLast());
            }
            return stack2.pollLast();
        }else {
            //没有元素可以弹出
            return -99;
        }
    }

    public int peek() {
        if(!stack2.isEmpty()){
            return stack2.peekLast();
        }else if (!stack1.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pollLast());
            }
            return stack2.peekLast();
        }else {
            //没有元素可以弹出
            return -99;
        }
    }

    public boolean empty() {
        if(stack2.isEmpty()&&stack1.isEmpty()){
            return true;
        }

        return false;
    }
}
