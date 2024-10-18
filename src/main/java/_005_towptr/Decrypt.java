package _005_towptr;

import java.util.Scanner;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/defuse-the-bomb/
 */
public class Decrypt {
    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }

        int sum = 0;

        if (k > 0) {
            int l = 0;
            int len = k + 1;
            // r - l + 1 = k + 1     l = n - 1   r = k + l = k + n - 1
            for (int r = 0; r < n + k; r++) {
                sum += code[r % n];
                if (r - l + 1 == len) {
                    ans[l] = sum - code[l];
                    sum -= code[l];
                    l++;
                }
            }
        } else {
            k = -k;
            //code = [5,7,1,4] 5 7 1, k = 3
            int l = n - k;   // n-1 -x +1 = k   x = n - k
            for (int i = l; i < n; i++) {
                sum += code[i];
            }

            for (int r = 0; r < n; r++) {
                ans[r] = sum;
                sum += code[r];
                sum -= code[l];
                l = (l + 1) % n;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] code = new int[n];
        for(int i=0;i<n;i++){
            code[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        int[] ans = decrypt(code, k);
        for (int i = 0; i < ans.length; i++) {
            if(i==0){
                System.out.printf("%d",ans[i]);
            }else {
                System.out.printf(" %d",ans[i]);
            }
        }
    }
}
