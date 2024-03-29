package _008_Backtracking;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/reconstruct-itinerary/
 */
public class FindItinerary {
    List<String> ans = new ArrayList<>();
    List<String > path = new ArrayList<>();

    Map<Pair<String,String>,Integer> vis = new HashMap<>();
    Map<String , Set<String>> mp = new HashMap<>();
    
    int cnt;
    public List<String> findItinerary(List<List<String>> tickets) {

        //初始化图
        for (List<String> ticket : tickets) {
            cnt++;
            String x = ticket.get(0);
            String y = ticket.get(1);
            Pair<String, String> pair = new Pair<String,String >(x,y);

            Set<String> strings = mp.get(x);
            if(mp.get(x)==null){
                strings = new HashSet<>();
            }
            strings.add(y);
            mp.put(x,strings);

            Integer orDefault = vis.getOrDefault(pair, 0)+1;
            vis.put(pair,orDefault);
        }

        path.add("JFK");
        dfs("JFK");
        return ans;
    }


    void dfs(String s){

        if(path.size() == cnt+1){
            if(ans.size()==0){
                ans = path;
            }else {
                ans = new ArrayList<>(minAns(ans,path));
            }

            return;
        }

        Set<String> strings = mp.get(s);

        if(strings==null){
            return;
        }


        for (String string : strings) {
            Pair<String, String> pair = new Pair<>(s, string);
            Integer integer = vis.get(pair);
            if(integer!=0){
                vis.put(pair, integer-1);
                path.add(string);
                dfs(string);
                vis.put(pair,integer+1);
                path.remove(path.size()-1);
            }
        }
    }


    List<String> minAns (List<String> l1 , List<String> l2){

        for (int i = 0; i < l1.size(); i++) {
            String s1 = l1.get(i);
            String s2 = l2.get(i);

            if(s1.equals(s2)){
                continue;
            }

            for (int j=0;j<s1.length();j++){

                if(s1.charAt(j)==s2.charAt(j)){
                    continue;
                }
                return s1.charAt(j) > s2.charAt(j) ?l2 : l1;
            }
        }
        //不会走到这
        return l1;
    }





    @Test
    public void test(){
        String[] arr = new String[]{"JFK","ATL","JFK","SFO","ATL","JFK"};
        String[] arr1 = new String[]{"JFK","ATL","JFK","SFO","ATL","SFO"};
        List<String> strings = minAns(Arrays.asList(arr), Arrays.asList(arr1));
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
