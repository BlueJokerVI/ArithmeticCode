package _000000_crawer;
import javafx.util.Pair;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Main {
    static List<String> s;
    int[] arr = new int[10];

    Map<Pair<String ,String >,Integer> mp = new HashMap<>();
    @Test
    public  void test() {
        Pair<String ,String > mpk = new Pair<>("1","2");

        mp.put(mpk,1);
        
        Pair<String ,String > mpk1 = new Pair<>("1","2");

        Integer integer = mp.get(mpk1);
        System.out.println(integer);
        System.out.println(mpk==mpk1);
    }


}
