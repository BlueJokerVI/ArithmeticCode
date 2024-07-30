package _006_StackAndQueue;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test1 {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> qAns = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums) {
            if (q.size() != k - 1) {
                q.offer(num);
            }else {
                if(!q.isEmpty() && num > q.peek()){
                    qAns.offer(q.poll());
                    q.offer(num);
                }else {
                    qAns.offer(num);
                }
            }
        }
        return qAns.peek();
    }

    @Test
    public void test(){
        findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4);
    }

}
