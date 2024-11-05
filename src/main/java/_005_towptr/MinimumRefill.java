package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/watering-plants-ii/
 */
public class MinimumRefill {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int n = plants.length;
        int l = 0, r = n - 1;
        long wa = capacityA, wb = capacityB;
        boolean f = false;
        while (l <= r) {

            if (l == r) {
                if (wa >= wb) {
                    f = false;
                    while (wa - plants[l] < 0) {
                        if (!f) {
                            wa = 0;
                            f = true;
                        }
                        ans++;
                        wa += capacityA;
                    }
                } else {
                    f = false;
                    while (wb - plants[l] < 0) {
                        if (!f) {
                            wb = 0;
                            f = true;
                        }
                        ans++;
                        wb += capacityB;
                    }
                }
            } else {
                f = false;
                while (wa - plants[l] < 0) {
                    if (!f) {
                        wa = 0;
                        f = true;
                    }
                    ans++;
                    wa += capacityA;
                }
                wa -= plants[l];

                f = false;
                while (wb - plants[r] < 0) {
                    if (!f) {
                        wb = 0;
                        f = true;
                    }
                    ans++;
                    wb += capacityB;
                }
                wb -= plants[r];
            }

            l++;
            r--;

        }

        return ans;
    }
}
