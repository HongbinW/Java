import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        int[][] matrix = process(4,5);
//        for(int[] arr : matrix){
//            for (int i : arr){
//                System.out.printf("%d ", i);
//            }
//            System.out.println();
//        }
        migong();
    }
    public static int[][] process(int n, int m){
        int[][] matrix = new int[n][m];
        int Ar = 0, Ac = 0, Br = 0, Bc = 0;             //A,B坐标
        boolean Uptodown = false;
        int index = 0;
        while(Ar <= n-1 && Ac <= m-1){
            if(Uptodown){
                for(int i = 0; i <= Br-Ar; i++) {
                    matrix[Ar+i][Ac-i] = index ++;
                }
                Uptodown = !Uptodown;
            }else{
                for(int i = 0; i <= Br-Ar; i++) {
                    matrix[Br-i][Bc+i] = index ++;
                }
                Uptodown = !Uptodown;
            }

            if(Ac < matrix[0].length-1){
                Ac++;
            }else{
                Ar++;
            }
            if(Br < matrix.length-1){
                Br++;
            }else{
                Bc++;
            }
        }
        return matrix;
    }
    public static void ZigZagPrintMatrix(int[][] matrix){       //A走到最后一行或者B走到最后一列即停止
        int Ar = 0, Ac = 0, Br = 0, Bc = 0;             //A,B坐标
        boolean Uptodown = false;
        while(Ar <= matrix.length-1 && Ac <= matrix[0].length-1){
            if(Uptodown){
                for(int i = 0; i <= Br-Ar; i++) {
                    System.out.println(matrix[Ar+i][Ac-i]);
                }
                Uptodown = !Uptodown;
            }else{
                for(int i = 0; i <= Br-Ar; i++) {
                    System.out.println(matrix[Br-i][Bc+i]);
                }
                Uptodown = !Uptodown;
            }

            if(Ac < matrix[0].length-1){
                Ac++;
            }else{
                Ar++;
            }
            if(Br < matrix.length-1){
                Br++;
            }else{
                Bc++;
            }
        }
    }
    
    public static void migong(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < B; i ++){
            matrix[sc.nextInt()][sc.nextInt()] = 1; // 1 障碍
        }
        System.out.println(minStep(matrix, N));
    }
    
    public static int minStep(int[][] matrix ,int N){
        int[][] dp = new int[N][N];
        for (int i = N - 2; i >= 0; i --){
            if (matrix[N-1][i] == 0 && matrix[N-1][i+1] == 0){
                dp[N-1][i] = dp[N-1][i+1] + 1;
            }else{
                dp[N-1][i] = N * N;
            }
            
            if (matrix[i][N-1] == 0 && matrix[i+1][N-1] == 0){
                dp[i][N-1] = dp[i+1][N-1] + 1;
            }else{
                dp[i][N-1] = N * N;
            }
        }
        for (int i = N-2; i >= 0; i --){
            for (int j = N - 2; j >= 0; j --){
                if (matrix[i][j] == 1){
                    dp[i][j] = N * N;
                }else{
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + 1;
                }
            }
        }
        return dp[0][0];
    }
}

