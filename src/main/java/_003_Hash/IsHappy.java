package _003_Hash;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-13  19:42
 * @Description: https://leetcode.cn/problems/happy-number/
 * 202. 快乐数
 * @Version: 1.0
 */
public class IsHappy {

    public boolean isHappy(int n) {

        if (n == 1) {
            return true;
        }

        Set<Integer> cnt = new HashSet<>();

        while (true) {

            n = getVal(n);

            if(n==1){
                return true;
            }

            if (cnt.contains(n)) {
                return false;
            }

            cnt.add(n);

        }

    }

    int getVal(int n){

        int val=0;

        while (n!=0){
            val += (n%10)*(n%10);
            n/=10;
        }

        return val;
    }

    @Test
    public void test() {
        this.isHappy(19);
    }
}
