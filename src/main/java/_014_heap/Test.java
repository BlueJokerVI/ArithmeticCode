package _014_heap;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.BiConsumer;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test {
    class MedianFinder {

        PriorityQueue<Integer> maxQ;
        PriorityQueue<Integer> minQ;
        boolean flag;

        public MedianFinder() {
            //大堆
            maxQ = new PriorityQueue<>(Comparator.reverseOrder());
            //小堆
            minQ = new PriorityQueue<>();
            flag = false;
        }

        public void addNum(int num) {
            if(!flag){
                if(!minQ.isEmpty() && num > minQ.peek()){
                    maxQ.offer(minQ.poll());
                    minQ.offer(num);
                }else {
                    maxQ.offer(num);
                }
                flag = true;
            }else {
                if(!maxQ.isEmpty() && num < maxQ.peek()){
                    minQ.offer(maxQ.poll());
                    maxQ.offer(num);
                }else {
                    minQ.offer(num);
                }
                flag = false;
            }
        }

        public double findMedian() {
            if (flag){
                System.out.println(flag);
                return maxQ.peek();
            }else {
                System.out.println(flag);
                return (maxQ.peek() + minQ.peek())*1.0/2;
            }
        }
    }
}
