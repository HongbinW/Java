package LeetCode.面试题系列;

import java.util.HashMap;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/26
 */
public class M16_02_WordsFrequency_单词频率 {
    class WordsFrequency {
        HashMap<String,Integer> map;
        public WordsFrequency(String[] book) {
            map = new HashMap<>();
            for (String str : book){
                if (!map.containsKey(str)){
                    map.put(str,1);
                }else{
                    map.put(str,map.get(str)+1);
                }
            }
        }

        public int get(String word) {
            if (!map.containsKey(word)){
                return 0;
            }else{
                return map.get(word);
            }
        }
    }
}
