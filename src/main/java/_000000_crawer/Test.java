package _000000_crawer;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test {
    @org.junit.Test
    public void test(){
        Deque<Integer> cur  = new ArrayDeque<>();
        cur.push(1);
        cur.push(2);
        cur.push(3);

        String collect = cur.stream().sorted(Comparator.comparingInt(o -> o)).map(integer -> {
            return integer.toString();
        }).collect(Collectors.joining("->"));
        System.out.println(collect);
    }
}
