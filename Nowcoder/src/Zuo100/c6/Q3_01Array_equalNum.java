package Zuo100.c6;

import java.util.HashMap;

/**
 * Description
 * Author  HongbinW
 * Date 2019/10/30
 */
//最长子串，其中0和1数量相等
    //思路：让所有的0变成-1，然后求最长和为0的子串
public class Q3_01Array_equalNum {
    public static int maxLength(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0,-1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i ++){
            sum += (arr[i] == 0 ? -1 : 1);
            if (!map.containsKey(sum)){
                map.put(sum,i);
            }else {
                res = Math.max(res,i - map.get(sum));       //有相等的，说明这段和为0
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxLength(new int[]{1,0,1,0,1,0,1,0,1,0}));
    }
}
