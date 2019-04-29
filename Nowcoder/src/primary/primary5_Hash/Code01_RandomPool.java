package primary.primary5_Hash;

import java.util.HashMap;

/**
 * @Author: HongbinW
 * @Date: 2019/4/28 21:36
 * @Version 1.0
 * @Description:
 */
public class Code01_RandomPool {
    public static class RandomPool {
        HashMap<String, Integer> map1;
        HashMap<Integer, String> map2;

        public RandomPool(){
            map1 = new HashMap<>();
            map2 = new HashMap<>();
        }

        public void insert(String str){
            if(!map1.containsKey(str)) {
                map1.put(str, map1.size());
                map2.put(map2.size(), str);
            }
        }

        public String getRandom(){
            if(map1.size() == 0){
                return null;
            }
            return map2.get((int)(Math.random() * map1.size()));
        }

        public void remove(String str){
            int value = map1.get(str);
            map1.remove(str);
            map1.put(map2.get(map2.size()-1),value);

            map2.put(value,map2.get(map2.size()-1));
            map2.remove(map2.size()-1); //插入的时候是根据当前的size插入，删除的时候，要-1
        }
    }
}
