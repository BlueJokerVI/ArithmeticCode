package _013_binary_search;

/**
 * @author cct
 * https://leetcode.cn/problems/nth-magical-number/
 */
public class NthMagicalNumber {
    public int nthMagicalNumber(int n, int a, int b) {
        long l = Math.min(a, b), r = Math.max(a, b) * 1000000000L;

        while (l <= r) {
            long mid = (r - l) / 2 + l;
            if (check(n, mid, a, b)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ((r + 1) % 1000000007);
    }

    boolean check(int n, long mid, int a, int b) {
        long t;
        int v = lcm(a, b);
        t = mid / a + mid / b;
        t -= mid / v;
        return t >= n;
    }


    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        NthMagicalNumber t = new NthMagicalNumber();
        t.nthMagicalNumber(1000000000,40000,40000);
    }
}
