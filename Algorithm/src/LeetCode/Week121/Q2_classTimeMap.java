package LeetCode.Week121;

import java.util.*;

/**
 * @Author: HongbinW
 * @Date: 2019/4/13 10:25
 * @Version 1.0
 * @Description:
 */
public class Q2_classTimeMap {
    /** Initialize your data structure here. */
    Map<String,ArrayList<Integer>> mapV = new HashMap<>();
    Map<String,String> mapT = new HashMap<>();

    public Q2_classTimeMap() {
    }

    public void set(String key, String value, int timestamp) {
        if(!mapV.containsKey(key)){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(timestamp);
            mapV.put(key,list);
            String temp = key + timestamp;
            mapT.put(temp,value);
        }else{
            ArrayList list = mapV.get(key);
            list.add(timestamp);
            mapV.put(key,list);
            String temp = key + timestamp;
            mapT.put(temp,value);
        }
    }

    public String get(String key, int timestamp) {
        if(mapV.containsKey(key)){
            ArrayList<Integer> list =  mapV.get(key);
            int resT = list.get(0);
            for(int i : list){
                resT = resT < i ? i : resT;
            }
            String temp = key + resT;
            return mapT.get(temp);
        }
        TreeMap<Integer,String> tree = new TreeMap<>();
        tree.floorEntry(timestamp);
        return null;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
