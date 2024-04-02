package _000000_crawer;
import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

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
        HashSet<String> strings = new HashSet<>();
        strings.add("S");
        strings.add("A");
        strings.add("B");

        for (String string : strings) {
            System.out.println(string);
        }

    }


}
