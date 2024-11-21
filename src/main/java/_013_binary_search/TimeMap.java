package _013_binary_search;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/time-based-key-value-store/
 */
public class TimeMap {

    HashMap<String, List<Object[]>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<Object[]>());
        map.get(key).add(new Object[]{timestamp, value});
    }

    public String get(String key, int timestamp) {
        List<Object[]> list = map.get(key);
        if(list == null){
            return "";
        }
        int i  = binarySearch(list, timestamp);
        if (i == -1){
            return "";
        }
        return (String)list.get(i)[1];
    }

    private int binarySearch(List<Object[]> data, int timestamp){
        int l = 0, r = data.size() - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if((int)data.get(m)[0] > timestamp){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return r;
    }


    public static void main(String[] args) {

        TimeMap timeMap = new TimeMap();
        timeMap.set("ctondw", "ztpearaw", 1);
        timeMap.set("vrobykydll", "hwliiq", 2);
        timeMap.set("gszaw", "ztpearaw", 3);
        timeMap.set("ctondw", "gszaw", 4);
        System.out.println(timeMap.get("gszaw", 5));
        System.out.println(timeMap.get("ctondw",6));
        System.out.println(timeMap.get("ctondw",7));
        System.out.println(timeMap.get("gszaw",8));
        System.out.println(timeMap.get("vrobykydll",9));
        System.out.println(timeMap.get("ctondw",10));
        timeMap.set("vrobykydll","kcvcjzzwx",11);
        System.out.println(timeMap.get("vrobykydll",12));
        System.out.println(timeMap.get("ctondw",13));
        System.out.println(timeMap.get("vrobykydll",14));
        timeMap.set("ztpearaw","zondoubtib",15);
        timeMap.set("kcvcjzzwx","hwliiq",16);
        timeMap.set("wtgbfvg","vrobykydll",17);
        timeMap.set("hwliiq","gzsiivks",18);
        System.out.println(timeMap.get("kcvcjzzwx",19));
        System.out.println(timeMap.get("ztpearaw",20));
    }
}
