package _001_shuzu;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/insert-delete-getrandom-o1/?envType=study-plan-v2&envId=top-interview-150
 */
public class RandomizedSet {


    private HashMap<Integer,Integer> mp;
    private final int[] list;
    private int lastIndex;
    private Random random;
    public RandomizedSet() {
        mp = new HashMap<>();
        list = new int[200001];
        lastIndex = -1;
        random = new Random();
    }

    public boolean insert(int val) {
        if (mp.containsKey(val)) {
            return false;
        }
        list[++lastIndex] = val;
        mp.put(val,lastIndex);
        return true;
    }

    public boolean remove(int val) {
        if (!mp.containsKey(val)) {
            return false;
        }
        int index = mp.remove(val);
        if(index!=lastIndex){
            int lastVal = list[lastIndex];
            list[index] = lastVal;
            mp.put(lastVal,index);
        }
        lastIndex--;
        return true;
    }

    public int getRandom() {
      return list[random.nextInt(lastIndex+1)];
    }


    @Test
    public void test(){
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        System.out.println(randomizedSet.getRandom());
    }
}
