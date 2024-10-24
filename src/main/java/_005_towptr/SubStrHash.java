package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/find-substring-with-given-hash-value/
 */
public class SubStrHash {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        long cur = 0;
        int ans = 0;
        //n-1-x+1=k x=n-k
        for (int i = n - 1; i >= n - k; i--) {
            cur = ((cur * power)%modulo + (cs[i] - 'a' + 1)) % modulo;
        }

        if(cur == hashValue){
            ans = n-k;
        }

        for (int i = n - k - 1; i >= 0; i--) {
            cur = ((cur * power) % modulo + (cs[i] - 'a' + 1) - ((cs[i + k] - 'a' + 1) * modPow(power, k, modulo))%modulo + modulo) % modulo;
            if (cur == hashValue) {
                ans = i;
            }
        }
        return s.substring(ans, ans + k);
    }


    public static long modPow(int base, int exp, int mod) {
        long result = 1;
        long power = base % mod;  // 先对 base 取模

        while (exp > 0) {
            if ((exp & 1) == 1) {  // 如果 exp 是奇数
                result = (result * power) % mod;
            }
            power = (power * power) % mod;  // 更新 power
            exp >>= 1;  // exp = exp / 2
        }

        return result;
    }

    public static void main(String[] args) {
        SubStrHash subStrHash = new SubStrHash();
        subStrHash.subStrHash("xmmhdakfursinye", 96, 45, 15, 21);
    }
}
