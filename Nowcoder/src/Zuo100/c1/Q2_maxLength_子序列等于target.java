package Zuo100.c1;

import java.util.HashMap;

/**
 * @Author: HongbinW
 * @Date: 2019/7/27 20:41
 * @Version 1.0
 * @Description:
 */
public class Q2_maxLength_子序列等于target {
    //Q1：正 ==target
    public int maxLength(int[] arr, int target){
        int L = 0,R = 0;
        int curSum = 0;
        int maxLen = 0;
        while (R <= arr.length){
            if (curSum < target){
                R ++;
                if (R <= arr.length){
                    curSum += arr[R-1];
                }else {
                    break;
                }
            }else if (curSum > target){
                L ++;
                curSum -= arr[L-1];
            }else{
                maxLen = Math.max(maxLen,R-L);
                R ++;
                curSum += arr[R-1];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        System.out.println(new Q2_maxLength_子序列等于target().maxLengthQ2(new int[]{3,1,1,1,6,4},6));
        System.out.println(new Q2_maxLength_子序列等于target().maxLengthAwesome(new int[]{3,-2,-4,0,6},-2));
    }

    //Q2：正、负、0 等于target
    public static int maxLengthQ2(int[] arr, int target){
        if (arr == null || arr.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0,-1);      //必须放，详情见笔记[注]  important!!
        int curSum = 0;
        int maxLen = 0;
        for (int i = 0 ; i < arr.length; i ++){
            curSum += arr[i];
            if (map.containsKey(target-curSum)){
                maxLen = Math.max(i - map.get(target - curSum),maxLen);
            }else{
                map.put(curSum,i);
            }
        }
        return maxLen;
    }

    //Q3：正、负、0，<=target
    public static int maxLengthAwesome(int[] arr, int k) {
        //记录第i个位置的minIndex
//        HashMap<Integer,Integer> map = new HashMap<>();
        int[] map = new int[arr.length];
        int[] minSum = new int[arr.length];
        minSum[arr.length-1] = arr[arr.length-1];
        map[arr.length-1] = arr.length-1;
        for (int i = arr.length-2 ; i >= 0 ; i --){
            if (minSum[i+1] <= 0){
                minSum[i] = arr[i] + minSum[i+1];
                map[i] = map[map[i+1]];
            }else{
                minSum[i] = arr[i];
                map[i] = i;
            }
        }
        int end = 0;
        int res = 0;
        int sum = 0;
        for (int i = 0 ; i < arr.length; i ++){
            while (end < arr.length && sum + minSum[end] <= k){
                sum += minSum[end];
                end = map[end] + 1;
            }
            sum -= end > i ? arr[i] : 0;
            res = Math.max(res,end-i);
            end = Math.max(end,i+1);
        }
        return res;
    }


}
