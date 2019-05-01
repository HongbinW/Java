package primary.primary7_Greed;

import java.util.PriorityQueue;

/**
 * @Author: HongbinW
 * @Date: 2019/4/30 13:04
 * @Version 1.0
 * @Description: 题目4
 */
public class Code03_LessMoney {
    public static int lessMoney(int[] arr){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            queue.offer(arr[i]);
        }
        int res = 0;
        while(queue.size() != 1){
            int q1 = queue.poll();
            int q2 = queue.poll();
            queue.offer(q1+q2);
            res += q1 + q2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,20,30};
        System.out.println(lessMoney(arr));
    }
}
