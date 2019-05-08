package examination.HuaWei.huawei_2019;

import java.util.Scanner;

public class Main{
    public static void rotate(int[][] matrix){
        int start1 = 0, end1 = 0;
        int start2 = matrix.length-1;
        int end2 = matrix[0].length-1;
        while (start1 <= start2 || end1 <= end2){
            rotate(matrix,start1++,end1++,start2--,end2--);
        }
    }
    public static void rotate(int[][] matrix, int start1, int end1, int start2, int end2){
        if(start1 == start2 && end1 == end2){
            return;
        }
        int count = start2 - start1;
        for(int i = 0; i < count; i++){
            int temp = matrix[start1][end1+i];
            matrix[start1][end1+i] = matrix[start2-i][end1];
            matrix[start2-i][end1] = matrix[start2][end2-i];
            matrix[start2][end2-i] = matrix[start1+i][end2];
            matrix[start1+i][end2] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            String s = sc.nextLine();
            if(s.equals(""))
                break;
            int N = Integer.parseInt(s);
            int[][] matrix = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            int count = sc.nextInt();
            for(int i = 0; i < count; i++){
                rotate(matrix);
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    System.out.print(matrix[i][j]);
                    if(j != N-1){
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}