package Zuo100.c7;

import java.util.PriorityQueue;

/**
 * Description
 * Author  HongbinW
 * Date 2019/11/5
 */
public class Q5_lessMoney_切金条 {
    public int lessMoney(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        if (arr.length == 1){
            return arr[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i ++){
            queue.add(arr[i]);
        }
        int res = 0;
        while (!queue.isEmpty()){
            int temp = queue.poll() + queue.poll();
            res += temp;
            if (!queue.isEmpty()) {
                queue.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q5_lessMoney_切金条().lessMoney(new int[]{6,7,8,9}));
    }
}
