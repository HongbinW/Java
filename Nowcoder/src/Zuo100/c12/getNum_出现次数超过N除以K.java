package Zuo100.c12;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Description
 * Author  HongbinW
 * Date 2019/11/19
 */
public class getNum_出现次数超过N除以K {
    public ArrayList<Integer> getNum(int[] arr, int K){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            if (map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else if (map.size() != K - 1){
                map.put(i,1);
            }else{
                for (int v : map.keySet()){
                    int times = map.get(v);
                    if (times == 1){
                        map.remove(v);
                    }else {
                        map.put(i,v-1);
                    }
                }
            }
        }
        HashMap<Integer,Integer> valid = new HashMap<>();
        for (int i = 0; i < arr.length; i ++){
            if (map.containsKey(arr[i]) && valid.containsKey(arr[i])){
                valid.put(arr[i],valid.get(arr[i])+1);
            }else if (map.containsKey(arr[i])){
                valid.put(arr[i],1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : valid.keySet()){
            list.add(i);
        }
        return list;
    }
}
