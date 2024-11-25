package _013_binary_search;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/heaters/
 */
public class FindRadius {


    //
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = Integer.MIN_VALUE;
        //二分找house左右两火炉，取距离近的，再在所有house距离中取最大的
        for (int house : houses) {
            int ge = findGe(heaters, house);
            int le = findLe(heaters, house);

            int v = Integer.MAX_VALUE;
            if (ge != heaters.length) {
                v = heaters[ge] - house;
            }
            if (le != -1) {
                v = Math.min(v,house -  heaters[le]);
            }

            ans = Math.max(ans, v);
        }
        return ans;
    }

    int findGe(int[] headers, int v) {
        int l = 0, r = headers.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (headers[mid] < v) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    int findLe(int[] headers, int v) {
        int l = 0, r = headers.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (headers[mid] <= v) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }


    public int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int n = houses.length;
        int m = heaters.length;
        //标记houses[i]左右第一个火炉的位置
        int[] r = new int[n];
        int[] l = new int[n];

        int ho = 0, he = 0;

        while (ho < n && he < m) {
            while (ho < n && houses[ho] <= heaters[he]) {
                l[ho] = heaters[he];
                ho++;
            }
            he++;
        }

        ho = n - 1;
        he = m - 1;
        while (ho >= 0 && he >= 0) {
            while (ho >= 0 && houses[ho] >= heaters[he]) {
                r[ho] = heaters[he];
                ho--;
            }
            he--;
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int v = Integer.MAX_VALUE;
            if (l[i] != 0) {
                v = l[i] - houses[i];
            }
            if (r[i] != 0) {
                v = Math.min(v, houses[i] - r[i]);
            }
            ans = Math.max(v, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        FindRadius t = new FindRadius();
        t.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4});
    }
}
