package _006_StackAndQueue;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2024-02-26  21:38
 * @Description: 337.前 K 个高频元素
 * https://leetcode.cn/problems/top-k-frequent-elements/solutions/402568/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
 * @Version: 1.0
 */
public class TopKFrequent {

    /**
     * 暴力排序 事件复杂度 nlogn
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent0(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        List<Map.Entry<Integer, Integer>> collect = mp.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> integerIntegerEntry = collect.get(i);
            ans.add(integerIntegerEntry.getKey());
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }


    /**
     * 维护小顶堆    时间复杂度 nlogk
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
            System.out.println(ret[i]);
        }
        return ret;
    }



    @Test
    public void test(){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o2 -  o1);

        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }


    public int[] topKFrequent1(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();

        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
            if(list[i] == null) continue;
            res.addAll(list[i]);
        }
        return res.stream().mapToInt(x->x).toArray();
    }

}
