package examination.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/2
 */
public class Main3_0_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int[][] lunch = new int[N][2];
        int[][] dinner = new int[M][2];
        int minKa = valid(lunch,N,sc,T);
        minKa = Math.min(minKa, valid(dinner,M,sc,T));
        Arrays.sort(lunch, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1]);
        Arrays.sort(dinner, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1]);
        for (int i = 0; i < lunch.length && lunch[i][0] < Integer.MAX_VALUE; i ++){
            int curKa = lunch[i][0];
            int curT = lunch[i][1];
            int range = midSearch(dinner,T - curT);
            for (int j = 0; j < range; j ++){
                if (curKa + dinner[j][0] < minKa){
                    minKa = curKa + dinner[j][0];
                }
            }
        }
        if(minKa == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(minKa);
        }
    }
    public static int midSearch(int[][] arr, int wantT){
        int left = 0;
        int right = arr.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (arr[mid][1] < wantT) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }

    public static int valid(int[][] arr, int K, Scanner sc, int T){
        int minIndex = -1;
        int minKa = Integer.MAX_VALUE;
        for (int i = 0; i < K; i ++){
            int ka = sc.nextInt();
            int t = sc.nextInt();
            arr[i] = new int[]{ka,t};
            if (t > T && ka < minKa){
                if (minIndex != -1){
                    arr[minIndex][1] = -1;
                    arr[minIndex][0] = Integer.MAX_VALUE;
                }
                minKa = ka;
                minIndex = i;
            }
        }
        return minKa;
    }
}
