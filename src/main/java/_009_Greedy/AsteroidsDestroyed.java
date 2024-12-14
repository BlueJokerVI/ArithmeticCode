package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/destroying-asteroids/
 */
public class AsteroidsDestroyed {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long cur = mass;
        Arrays.sort(asteroids);
        for (int asteroid : asteroids) {
            if (cur >= asteroid) {
                cur += asteroid;
            } else {
                return false;
            }
        }
        return true;
    }
}
