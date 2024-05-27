package _006_StackAndQueue;

import org.junit.Test;

import java.util.Stack;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/min-stack/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinStack {

    int[] stack;
    /**
     * 记录之前最小值的下标
     */
    int[] preMin;
    int top;
    long min;
    int minIndex;
    public MinStack() {
        stack = new int[30001];
        preMin = new int[30001];
        top=-1;
        min = Long.MAX_VALUE;
        minIndex=-1;

    }

    public void push(int val) {
        stack[++top] = val;
        if(val <= min){
            preMin[top] = minIndex;
            minIndex = top;
            min = val;
        }
    }

    public void pop() {
        int x = top();
        if(x==min){
            int preMinIndex = preMin[top];
            min =preMinIndex==-1? Long.MAX_VALUE :stack[preMinIndex];
            minIndex = preMinIndex;
        }
        top--;
    }

    public int top() {
        if(top < 0){
            return -1;
        }
        return stack[top];
    }

    public int getMin() {
        return (int)min;
    }

    //维护两个stack的写法
    class MinStack1 {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MinStack1() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int val) {
            stack1.push(val);
            if(stack2.isEmpty()||val<=stack2.peek()){
                stack2.push(val);
            }
        }

        public void pop() {
            Integer pop = stack1.pop();
            //当integer的绝对值大于127时，integer之间的比较，不是比较值而是对象地址，需要转化为int
            if(pop.intValue()==stack2.peek().intValue()){
                stack2.pop();
            }
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }

    @Test
    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        int top1 = minStack.top();
        minStack.pop();
        int min1 = minStack.getMin();
        minStack.pop();
        int min2 = minStack.getMin();
        minStack.pop();
    }
}
