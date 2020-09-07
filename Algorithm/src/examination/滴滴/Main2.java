package examination.滴滴;

import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        int N = sc.nextInt();
        process(N);
    }
    public static long[] produceFib(int n){
        long[] arr = new long[n * n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n * n; i ++){
            arr[i] = arr[i-1] + arr[i - 2];
        }
        return arr;
    }
    public static void process(int n){
        if (n == 1){
            System.out.println(1);
            return;
        }else if (n == 2){
            System.out.println(3 + " " + 2);
            System.out.println(1 + " " + 1);
            return;
        }
        long[] arr = produceFib(n);
        int index = arr.length - 1;
        int startRow = 0,endRow = n - 1;
        long[][] matrix = new long[n][n];
        while (startRow < endRow){
            index = putMetrix(arr,index,startRow,endRow,matrix);
            startRow ++;
            endRow --;
        }
        if (startRow == endRow){
            matrix[startRow][startRow] = 1;
        }
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j ++){
                System.out.printf("%d", matrix[i][j]);
                if (j != n - 1){
                    System.out.printf(" ");
                }
            }
            System.out.println();
        }
    }
    public static int putMetrix(long[] arr, int index, int startRow, int endRow, long[][] metrix){
        for (int i = startRow; i < endRow; i ++){
            metrix[startRow][i] = arr[index--];
        }
        for (int i = startRow; i < endRow; i ++){
            metrix[i][endRow] = arr[index--];
        }
        for (int i = endRow; i > startRow; i --){
            metrix[endRow][i] = arr[index--];
        }
        for (int i = endRow; i > startRow; i --){
            metrix[i][startRow] = arr[index--];
        }
        return index;
    }


}