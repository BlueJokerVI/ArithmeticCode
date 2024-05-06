package _012_graphic;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/all-paths-from-source-to-target/
 */
public class AllPathsSourceTarget {
    List<List<Integer>> path = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(0, graph);
        return path;
    }

    void dfs(int index, int[][] graphic) {
        cur.add(index);

        if (index == graphic.length - 1) {
            path.add(new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
            return;
        }

        for (int i = 0; i < graphic[index].length; i++) {
            dfs(graphic[index][i], graphic);
        }
        cur.remove(cur.size() - 1);
    }
}
