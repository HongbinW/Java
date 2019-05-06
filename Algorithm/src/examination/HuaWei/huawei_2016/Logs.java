package examination.HuaWei.huawei_2016;

import java.util.*;

public class Logs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>();
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();

        while(sc.hasNext()){
            String file = sc.next();
            if (file.equals(""))
                break;
            String row = sc.next();
            String key = file.substring(file.lastIndexOf('\\')+1) + " " + row;
            if(!map.containsKey(key)){
                map.put(key,0);
            }
            map.put(key,map.get(key)+1);
        }
        for(Map.Entry ele : map.entrySet()){
            list.add(ele);
        }
        Collections.sort(list,(o1,o2)->o2.getValue()-o1.getValue());
        for(int i = 0 ; i < list.size() && i < 8; i++) {
            String res = list.get(i).getKey();
            if(res.indexOf(" ") > 16){
                int index = res.indexOf(" ");
                res = res.substring(index - 16);
            }
            System.out.print(res + " ");
            System.out.println(list.get(i).getValue());
        }
    }
}
