package LeetCode.casuallly;

import java.util.HashMap;

public class LeetCode13_romanToInt_罗马数字转整数 {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] chs = s.toCharArray();
        int res = map.get(chs[chs.length-1]);
        for (int i = chs.length - 2; i >= 0; i --){
            if (map.get(chs[i]) >= map.get(chs[i+1])){
                res += map.get(chs[i]);
            }else{
                res -= map.get(chs[i]);
            }
        }
        return res;
    }
}
