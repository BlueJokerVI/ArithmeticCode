package _006_StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-26  21:07
 * @Description: https://leetcode.cn/problems/implement-stack-using-queues/
 * 225. 用队列实现栈
 * @Version: 1.0
 */
public class MyStack {

    private Deque<Integer> deque;

    public MyStack() {
        deque  = new ArrayDeque<>();

    }

    public void push(int x) {
        deque.offerLast(x);
    }

    public int pop() {
       if(empty()){
           return -99;
       }

       int n = deque.size()-1;

        for (int i = 0; i < n; i++) {
            deque.offerLast(deque.pollFirst());
        }

        return deque.pollFirst();

    }

    public int top() {
        if(empty()){
            return -99;
        }

        int n = deque.size()-1;

        for (int i = 0; i < n; i++) {
            deque.offerLast(deque.pollFirst());
        }
        int v = deque.peekFirst();
        deque.offerLast(deque.pollFirst());
        return v;

    }

    public boolean empty() {
        return deque.isEmpty();
    }

}
