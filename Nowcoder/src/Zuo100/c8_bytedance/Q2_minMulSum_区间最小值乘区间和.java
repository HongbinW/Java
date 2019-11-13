package Zuo100.c8_bytedance;

import java.util.HashMap;
import java.util.Stack;

public class Q2_minMulSum_区间最小值乘区间和 {
    public int minMultiSum(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();   //从小到大
        int res = 0;
        for (int i = 0; i < arr.length; i ++){
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                int cur = stack.pop();
                int sum = 0;
                for (int j = cur; j < i; j ++){
                    sum += arr[j];
                }
                res = Math.max(res,sum * arr[cur]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int cur = stack.pop();
            int sum = 0;
            for (int j = cur; j < arr.length; j ++){
                sum += arr[j];
            }
            res = Math.max(res,sum * arr[cur]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q2_minMulSum_区间最小值乘区间和().minMultiSum(new int[]{1}));
    }
}
