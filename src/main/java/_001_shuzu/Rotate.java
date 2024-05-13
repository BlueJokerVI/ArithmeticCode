package _001_shuzu;
import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        k = k% nums.length;
        int[]  tmp = new int[nums.length];
        int index = 0;
        for (int i = nums.length-k; i < nums.length; i++) {
            tmp[index++] = nums[i];
        }
        for(int i=0;i<nums.length-k;i++) {
            tmp[index++] = nums[i];
        }
        for (int i = 0; i < tmp.length; i++) {
            nums[i] = tmp[i];
        }
    }


    //环装替代法
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = 0;
        int start = 0;
        while (true){
            int preValue = nums[start];
            int next = (start+k)%n;
            while (next!= start){
                int tmp = nums[next];
                nums[next] = preValue;
                count++;
                //count==n说明所有元素都以遍历移动完毕
                if(count==n){
                    return;
                }
                preValue = tmp;
                next = (next + k)%n;
            }
            nums[start] = preValue;
            count++;
            if(count==n){
                return;
            }
            start++;
        }
    }

    //反转数组法
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }


    //反转数组nums在start和end之间的元素
    private void reverse(int[] nums,int start,int end){
          while (start < end){
              int tmp = nums[end];
              nums[end] = nums[start];
              nums[start] = tmp;
              start++;
              end--;
          }
    }


    @Test
    public void test(){
        rotate1(new int[]{1,2,3,4,5,6,7},3);
    }

}
