package _008_Backtracking;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/combination-cur-ii/
 */
public class Combinationcur2 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int cur = 0;

    /**
     * 标记每个节点可以重复的次数
     */
    int[] cnt = new int[51];
    public List<List<Integer>> combinationcur2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.fill(cnt,0);
        for (int candidate : candidates) {
            if(!list.contains(candidate)){
                list.add(candidate);
            }
            cnt[candidate]++;
        }

        dfs(0,list,target);
        return ans;
    }

    void dfs(int index,List<Integer> list, int target){
        if(cur>target){
            return;
        }
        if(cur==target){
            ans.add(new ArrayList<>(path));

            return;
        }

        for (int i = index; i < list.size(); i++) {
            int v = list.get(i);


            cur += v;
            path.add(v);
            if(cnt[v]==1){
                dfs(i+1,list,target);
            }else {
                cnt[v]--;
                dfs(i,list,target);
                cnt[v]++;
            }
            cur -=v;
            path.remove(path.size()-1);

        }

    }

    /**
     * 每层取重
     * @param index
     * @param candidates
     * @param target
     */
    void dfs1(int index,int[] candidates, int target){

        if ( cur == target ) {
            ans.add( new ArrayList<>( path ) );
            return;
        }
        for ( int i = index; i < candidates.length && cur + candidates[i] <= target; i++ ) {
            //正确剔除重复解的办法
            //跳过同一树层使用过的元素
            if ( i > index && candidates[i] == candidates[i - 1] ) {
                continue;
            }

            cur += candidates[i];
            path.add( candidates[i] );
            // i+1 代表当前组内元素只选取一次
            dfs1( i + 1,candidates, target);
            cur -= candidates[i];
            path.remove(path.size()-1);

        }

    }


    @Test
    public void test(){
        int t[] = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        this.combinationcur2(t,5);

    }


}
