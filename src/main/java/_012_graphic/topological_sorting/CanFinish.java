package _012_graphic.topological_sorting;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/course-schedule/?envType=study-plan-v2&envId=top-interview-150
 */
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        int[][] mp = new int[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[0];
            int next = prerequisite[1];
            mp[pre][next] = 1;
            in[next] ++;
        }

        int cnt = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if(in[i]==0){
                deque.offer(i);
                cnt++;
            }
        }


        while (!deque.isEmpty()){
            int v = deque.remove();
            for(int i=0;i<numCourses;i++){
                if(mp[v][i]==1){
                    in[i]--;
                    if(in[i]==0){
                        cnt++;
                        deque.offer(i);
                    }
                }
            }
        }
        return cnt==numCourses;
    }
}
