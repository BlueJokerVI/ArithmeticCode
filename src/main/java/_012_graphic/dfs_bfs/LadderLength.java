package _012_graphic.dfs_bfs;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/word-ladder/
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> stringHashSet = new HashSet<>(wordList);
        HashMap<String,Boolean> vis = new HashMap<>(wordList.size()+1);

        Deque<String> q = new ArrayDeque<>();
        q.push(beginWord);
        int step = 0;
        boolean find = false;
        while (!q.isEmpty()){
            step++;
            ArrayList<String > list = new ArrayList<>(q);
            q.clear();
            for (String str : list) {
                if(str.equals(endWord)){
                    find = true;
                    break;
                }
                for (int i = 0; i < str.length(); i++) {
                    StringBuilder cur = new StringBuilder(str);
                    for(char c = 'a' ;c<='z';c++){
                        if(cur.charAt(i)==c){
                            continue;
                        }
                        cur.setCharAt(i,c);

                        if(stringHashSet.contains(cur.toString()) && !vis.getOrDefault(cur.toString(), false)){
                            vis.put(cur.toString(),true);
                            q.push(cur.toString());
                        }
                    }
                }
            }
            if(find){
                break;
            }
        }
        return vis.getOrDefault(endWord,false) ? step : 0;
    }


    @Test
    public void test(){
        ArrayList<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("lot");
        list.add("log");
        list.add("cog");
        list.add("dog");
        int i = ladderLength("hit", "cog", list);
        System.out.println(i);
    }


}
