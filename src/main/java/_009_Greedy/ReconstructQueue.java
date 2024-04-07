package _009_Greedy;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/queue-reconstruction-by-height/
 */
public class ReconstructQueue {

    /**
     * [7,0],[4,4],[7,1],[5,0],[6,1],[5,2]
     *
     * 0      1     2     3     4      5
     * [7,0],[7,1],[6,1],[5,0],[5,2],[4,4]
     *
     * [5,0],[7,0],[5,2],[6,1],[4,4],[7,1]
     */
    public int[][] reconstructQueue(int[][] people) {

        List<List<Integer>> tmpAns = new ArrayList<>(people.length);

        //按照身高从大到小排序,身高相等按k值从小到大排序
        Arrays.sort(people, (o1, o2) -> {
            if(o2[0]-o1[0]!=0){
                return o2[0]-o1[0];
            }else {
                return o1[1]-o2[1];
            }
        });


        for (int i = 0; i < people.length; i++) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(people[i][0]);
            integers.add(people[i][1]);
            tmpAns.add(people[i][1],integers);
        }

        // 使用 Stream 将 List<List<Integer>> 转为 int[][]
        int[][] result = tmpAns.stream()
                .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        return result;
    }



    //思路一样
    public int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return b[0]-a[0];
        });
        LinkedList<int[]> que=new LinkedList<>();
        for(int[] p:people){
            que.add(p[1],p);
        }
        return que.toArray(new int[people.length][]);
    }

    @Test
    public void test(){

       /* int[][] ans = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        reconstructQueue(ans);*/

//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(0,1);
//        integers.add(0,2);
//        integers.add(0,3);
//
//        for (Integer integer : integers) {
//            System.out.println(integer);
//        }

    }


}
