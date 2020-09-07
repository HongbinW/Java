package examination.猿辅导;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main2{
    static class Classmate{
        int value;
        int from;
        int dp;
        Classmate(int value, int from){
            this.value = value;
            this.from = from;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Integer,Classmate> map = new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> mate = new HashMap<>();
        int index = 2;
        for (int i = 0; i < N; i ++, index++){
            int value = sc.nextInt();
            int fron = sc.nextInt();
            map.put(index, new Classmate(value,fron));
            if (!mate.containsKey(fron)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(index);
                mate.put(fron,list);
            }else{
                mate.get(fron).add(index);
            }
        }
        Long res = Long.MIN_VALUE;
        HashMap<Integer,Long> values = new HashMap<>();
        for (int key : map.keySet()){
            process(map,key,values,0);
        }
        for (int key : mate.keySet()){
            ArrayList<Integer> list = mate.get(key);
            long tmp = map.get(key).value;
            for (int i = 0; i < list.size(); i ++){
                tmp += Math.max(list.get(i),0);
            }
            values.put(key,tmp);
        }
        for (int key : values.keySet()){
            res = Math.max(res, values.get(key));
        }
        System.out.println(res);
    }
    public static void process(HashMap<Integer,Classmate> map, int target, HashMap<Integer,Long> values, long base){
        if (target == 0){
            return;
        }
        long cur = (map.get(target).value + base) % 1000000003;
        if (!values.containsKey(target) || cur > values.get(target)){
            values.put(target,cur);
            process(map,map.get(target).from,values,Math.max(0,cur));
        }
    }
}

