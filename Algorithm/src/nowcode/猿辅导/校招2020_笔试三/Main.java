package nowcode.猿辅导.校招2020_笔试三;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/18
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i ++){
            for (int j = 0; j < M; j ++){
                arr[i][j] = sc.nextInt();
            }
        }
        int startRow = 0, startCol = 0;
        int endRow = N-1, endCol = M-1;
        while (startRow <= endRow && startCol <= endCol){
            process(arr,startRow,startCol,endRow,endCol);
            startRow ++;
            startCol ++;
            endRow --;
            endCol --;
        }
    }

    public static void process(int[][] arr, int startRow, int startCol, int endRow, int endCol){
        if (startRow == endRow){
            for (int i = startCol; i <= endCol; i ++){
                System.out.printf("%d ",arr[startRow][i]);
            }
        }else if (startCol == endCol){
            for (int i = startRow; i <= endRow; i ++){
                System.out.printf("%d ",arr[i][startCol]);
            }
        }else{
            for (int i = startRow; i < endRow; i ++){
                System.out.printf("%d ",arr[i][startCol]);
            }
            for (int i = startCol; i < endCol; i ++){
                System.out.printf("%d ",arr[endRow][i]);
            }
            for (int i = endRow; i > startRow; i --){
                System.out.printf("%d ",arr[i][endCol]);
            }
            for (int i = endCol; i > startCol; i --){
                System.out.printf("%d ", arr[startRow][i]);
            }
        }
    }
}
