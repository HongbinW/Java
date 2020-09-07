package examination.美团;

import java.util.Arrays;
import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n];
        int[] order = new int[n];
        for (int i = 0; i < n; i ++){
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i ++){
            order[i] = sc.nextInt();
        }
//        int[] sum = new int[n];
//        sum[0] = weight[0];
//        for (int i = 1; i < n; i ++){
//            sum[i] = sum[i-1] + weight[i];
//        }
//        int[] from = new int[n];    //当前index的起始位置是多少
//        int[] to = new int[n];  // 当前位置持续到哪
//        Arrays.fill(to,n-1);
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i ++){
//            process(sum, order[i]-1, from, to);
            process(weight,order[i]-1,visited);
        }
    }
    public static void process(int[] weight, int index, boolean[] visited){
        visited[index] = true;
        int max = 0;
        int cur = 0;
        for (int i = 0; i < weight.length; i ++){
            if (!visited[i]){
                cur += weight[i];
            }else{
                max = Math.max(max, cur);
                cur = 0;
            }
        }
        System.out.println(max);
    }
    // 删掉时，置为自身index
//    public static void process(int[] sum, int index, int[] from, int[] to){
//        int start = 0;
//        int max = 0;
//        while (to[start] < index){
//            max = Math.max(max, sum[to[start]] - (start == 0 ? 0 : sum[start-1]));
//            start = to[start] + 1;
//        }
//        int end = sum.length - 1;
////        max = Math.max(max, sum[end] - sum[from[end]]);
//        while (from[end] > index){
//            max = Math.max(max, sum[end] - sum[from[end-1]]);
//            end = from[end] - 1;
//        }
//        if (index - 1 >= 0 && to[index-1] != index - 1) {
//            to[index - 1] = index - 1;
//        }
//        if (index + 1 < sum.length && from[index+1] != index + 1) {
//            from[index + 1] = index + 1;
//        }
//        from[end] = index + 1;
//        to[start] = index - 1;
//        to[index] = index;
//        from[index] = index;
//        int pre = sum[index-1] - (start == 0 ? 0 : sum[start-1]);
//        int next = sum[end] - sum[index];
//        max = Math.max(max, pre);
//        max = Math.max(max, next);
//        System.out.println(max);
//    }
}