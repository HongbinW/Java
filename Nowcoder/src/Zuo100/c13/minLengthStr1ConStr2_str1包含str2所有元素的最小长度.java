package Zuo100.c13;

import java.util.HashMap;

/**
 * Description
 * Author  HongbinW
 * Date 2019/11/17
 */
public class minLengthStr1ConStr2_str1包含str2所有元素的最小长度 {
    public int minLength(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str2.length(); i ++){
            if(!map.containsKey(str2.charAt(i))){
                map.put(str2.charAt(i),1);
            }else{
                map.put(str2.charAt(i),map.get(str2.charAt(i)) + 1);
            }
        }
        int L = 0, R = 0, all = str2.length();
        int res = str1.length();
        while (R < str1.length()){
            while (R < str1.length() && all > 0){
                if (map.containsKey(str1.charAt(R))){
                    map.put(str1.charAt(R),map.get(str1.charAt(R))-1);
                    all --;
                }
                R ++;
            }
            while (R < str1.length() && L < R){
                if (map.containsKey(str1.charAt(L))){
                    all ++;
                    L ++;
                    break;
                }
                L ++;
            }
            res = Math.min(res,R - L + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new minLengthStr1ConStr2_str1包含str2所有元素的最小长度().minLength("cdwea","ce"));
    }
}
