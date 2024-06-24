package _014_heap;

import javafx.scene.layout.Priority;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/find-median-from-data-stream/?envType=study-plan-v2&envId=top-interview-150
 */
public class MedianFinder {

    PriorityQueue<Integer> leftQ  = new PriorityQueue<>((a,b)-> b-a);  //大根堆
    PriorityQueue<Integer> rightQ  = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if(leftQ.size()==rightQ.size()){
            if(leftQ.size()==0 || num < rightQ.peek()){
                leftQ.add(num);
            }else {
                leftQ.add(rightQ.poll());
                rightQ.add(num);
            }
        }else {
            if(num > leftQ.peek()){
                rightQ.add(num);
            }else {
                rightQ.add(leftQ.poll());
                leftQ.add(num);
            }
        }
    }

    public double findMedian() {
        if(leftQ.size()!=rightQ.size()){
            return leftQ.peek();
        }else {
            return (leftQ.peek()+rightQ.peek())*1.0/2;
        }
    }

}
