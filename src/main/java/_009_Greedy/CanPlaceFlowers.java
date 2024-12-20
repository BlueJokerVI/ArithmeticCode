package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/can-place-flowers/
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean can = true;
                if (i - 1 >= 0 && flowerbed[i-1] == 1) {
                    can = false;
                }

                if (i + 1 < flowerbed.length && flowerbed[i + 1] == 1) {
                    can = false;
                }

                if (can) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        return n <= 0;
    }
}
