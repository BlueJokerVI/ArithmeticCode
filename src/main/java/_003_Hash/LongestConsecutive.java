package _003_Hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description:
 */
public class LongestConsecutive {


    class Node{
        int v;
        int index;
    }

    Node fa[] = new Node[100001];

    //返回父亲节点的索引
    Node find(Node node){
        if(node.v==fa[node.index].v){
            return node;
        }else {
            return fa[node.index] = find(fa[node.index]);
        }
    }

    void join(Node a,Node b){
        Node fatherA = find(a);
        Node fatherB = find(b);
        fa[fatherB.index] = fatherA ;
    }

    public int longestConsecutive(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        Map<Integer,Node> mp= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                continue;
            }

            Node node = new Node();
            node.v = nums[i];
            node.index = i;
            fa[i] = node;
            mp.put(nums[i],node);
            set.add(nums[i]);
            if (set.contains(nums[i] - 1)) {
                join(mp.get(nums[i]-1), node);
            }
            if (set.contains(nums[i] + 1)) {
                join(node, mp.get(nums[i]+1));
            }
        }

        Map<Integer,Integer > cnt = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        set.clear();
        for (int num : nums) {
            if(set.contains(num))
            {
                continue;
            }
            Node father = find(mp.get(num));
            set.add(num);
            int v = cnt.getOrDefault(father.index,0)+1;
            cnt.put(father.index,v);
            if(v>ans){
                ans = v;
            }
        }

        return ans;
    }



    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            for (int num : nums) {
                num_set.add(num);
            }

            int longestStreak = 0;

            for (int num : num_set) {

                //枚举连续序列的第一个数
                if (!num_set.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    while (num_set.contains(currentNum + 1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
        }
    }

    @Test
    public void test(){
        longestConsecutive(new int[]{100,4,200,1,3,2});
    }
}
