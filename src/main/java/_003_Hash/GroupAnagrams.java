package _003_Hash;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-09  21:50
 * @Description: TODO
 * @Version: 1.0
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs.length==0){
            return new ArrayList<>();
        }

        if (strs.length==1){
            List<List<String>> arrayLists = new ArrayList<>();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(strs[0]);
            arrayLists.add(arrayList);
            return arrayLists;
        }


        List<List<String>> ans = new ArrayList<>();

        List<Map<Character,Integer>>  cnts = new ArrayList<>();

        Map<Integer ,List<String> > tmp = new HashMap<>();



        Map<Character,Integer>  cnt = new HashMap<>();
        char[] cs = strs[0].toCharArray();
        for(char c: cs){
            cnt.put(c,cnt.getOrDefault(c,0)+1);
        }
        cnts.add(cnt);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(strs[0]);
        tmp.put(0,arrayList);

        for (int i = 1; i < strs.length; i++) {

            cnt = new HashMap<>();
            cs = strs[i].toCharArray();
            for(char c: cs){
                cnt.put(c,cnt.getOrDefault(c,0)+1);
            }


            //标记死否找到相符合的类
            int f1 = 1;

            for (int j = 0; j < cnts.size(); j++) {

                if (cnt.size()!=cnts.get(j).size()){
                    continue;
                }

                Map<Character, Integer> cnt2 = cnts.get(j);
                int f = 1;

                for(char c: cs){
                    if (!cnt.get(c).equals(cnt2.get(c))){
                        f = 0;
                        break;
                    }
                }

                //找到相同类
                if (f==1){
                    List<String> strings = tmp.get(j);
                    strings.add(strs[i]);
                    tmp.replace(j,strings);
                    f1 = 0;
                    break;
                }
            }

            //又多了一种
            if(f1==1){
                cnts.add(cnt);
                arrayList.clear();
                arrayList.add(strs[i]);

                tmp.put(cnts.size()-1,arrayList);
            }
        }

        tmp.forEach((k,v)->{
            ans.add(v);
        });

        return ans;
    }



    @Test
     public void test(){
        String[] s  = {"eat","tea","tan","ate","nat","bat"};
        this.groupAnagrams(s);
    }
}
