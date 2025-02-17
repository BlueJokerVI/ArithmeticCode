package _012_graphic.dfs_bfs;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description:
 */
public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[0];
            int next = prerequisite[1];

            List<Integer> integers = mp.computeIfAbsent(pre, k -> new ArrayList<>());
            integers.add(next);
            in[next]++;
        }

        int[] ans = new int[numCourses];
        int cnt = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if(in[i]==0){
                deque.offer(i);
                ans[cnt++] = i;
                cnt++;
            }
        }

        while (!deque.isEmpty()){
            Integer node = deque.remove();
            List<Integer> integers = mp.get(node);
            if(integers!=null){
                for (int integer : integers) {
                    in[integer] --;
                    if(in[integer]==0){
                        deque.offer(integer);
                        ans[cnt++] = integer;
                    }
                }
            }
        }

        reverse(ans);

        return cnt==numCourses ? ans: new int[0];
    }

    void reverse(int[] nums){
        int l=0;
        int r = nums.length-1;
        while (l<=r){
            int tmp = nums[r];
            nums[r] = nums[l];
            nums[l] = tmp;
            l++;
            r--;
        }
    }



    // 存储有向图
    List<List<Integer>> edges;
    // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
    int[] visited;
    // 用数组来模拟栈，下标 n-1 为栈底，0 为栈顶
    int[] result;
    // 判断有向图中是否有环
    boolean valid = true;
    // 栈下标
    int index;

    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        }
        // 如果没有环，那么就有拓扑排序
        return result;
    }

    public void dfs(int u) {
        // 将节点标记为「搜索中」
        visited[u] = 1;
        // 搜索其相邻节点
        // 只要发现有环，立刻停止搜索
        for (int v: edges.get(u)) {
            // 如果「未搜索」那么搜索相邻节点
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            }
            // 如果「搜索中」说明找到了环
            else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        // 将节点标记为「已完成」
        visited[u] = 2;
        // 将节点入栈
        result[index--] = u;
    }
}
