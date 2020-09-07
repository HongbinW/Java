package examination.大疆;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] weight = new int[N];
        int[] value = new int[N];
        for (int i = 0; i < N; i ++){
            value[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }
        System.out.println(process(weight,value,X));
    }
    public static int process(int[] weight, int[] value, int maxWeight){
        int n = weight.length;
        int[][] maxValue = new int[n+1][maxWeight + 1];
        for (int i = 0; i < maxWeight+1; i ++){
            maxValue[0][i] = 0;
        }
        for (int i = 0; i < n + 1; i ++){
            maxValue[i][0] = 0;
        }

        for (int i = 1; i <= n; i ++){
            for (int j = 1; j <= maxWeight; j ++){
                maxValue[i][j] = maxValue[i-1][j];
                if (weight[i-1] <= j){
                    if (maxValue[i-1][j-weight[i-1]] + value[i-1] > maxValue[i-1][j]){
                        maxValue[i][j] = maxValue[i-1][j-weight[i-1]] + value[i-1];
                    }
                }
            }
        }
        return maxValue[n][maxWeight];
    }
}