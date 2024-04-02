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
            Pair<String, String> pair = new Pair<>(x,y);

            Set<String> strings = mp.get(x);
            if(mp.get(x)==null){
                //使用TreeSet保证路径有序，从小到大
                strings = new TreeSet<>();
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

        if(ans.size()!=0){
            return;
        }
        //得到一个路径就是满足条件的路径
        if(path.size() == cnt+1){
            ans = new ArrayList<>(path);
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
                vis.put(pair,integer);
                path.remove(path.size()-1);
            }
        }
    }






    @Test
    public void test(){
//        String[] arr = new String[]{"JFK","ATL","JFK","SFO","ATL","JFK"};
//        String[] arr1 = new String[]{"JFK","ATL","JFK","SFO","ATL","SFO"};
//        List<String> strings = minAns(Arrays.asList(arr), Arrays.asList(arr1));
//        for (String string : strings) {
//            System.out.println(string);
//        }


        List<List<String>> tickets = new ArrayList<>();
        List<String> tmp1 = new ArrayList<>();
        List<String> tmp2 = new ArrayList<>();
        List<String> tmp3 = new ArrayList<>();
        List<String> tmp4 = new ArrayList<>();
        List<String> tmp5 = new ArrayList<>();

        tmp1.add("JFK");
        tmp1.add("SFO");
        tmp2.add("JFK");
        tmp2.add("ATL");
        tmp3.add("SFO");
        tmp3.add("ATL");
        tmp4.add("ATL");
        tmp4.add("JFK");
        tmp5.add("ATL");
        tmp5.add("SFO");
        tickets.add(tmp1);
        tickets.add(tmp2);
        tickets.add(tmp3);
        tickets.add(tmp4);
        tickets.add(tmp5);

        Collections.sort(tickets, Comparator.comparing(a -> a.get(1)));

        System.out.println(1);

    }

}
