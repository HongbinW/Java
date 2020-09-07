package LeetCode.每日一题;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/26
 */
public class LeetCode329_longestIncreasingPath_矩阵中最长递增路径 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{9,9,4}, {6,6,8}, {2,1,1}};
        System.out.println(new LeetCode329_longestIncreasingPath_矩阵中最长递增路径().longestIncreasingPath(matrix));
    }
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][] arr = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[0].length; j ++){
                if (arr[i][j] == 0){        //只需要找值为0的位置，因为只有经过了的才不是0，而从经过了的去找，肯定找不到最大
                    arr[i][j] = 1;
                    process(matrix,arr,i,j);
                }
            }
        }
        return res;
    }
    int res = 1;
    public void process(int[][] matrix, int[][] arr, int row, int col){
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        for (int i = 0; i < 4; i ++){
            int x = row + dx[i];
            int y = col + dy[i];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length &&
                    matrix[x][y] > matrix[row][col] && arr[x][y] < arr[row][col] + 1){
                res = Math.max(res, arr[row][col] + 1);
                arr[x][y] = arr[row][col] + 1;
                process(matrix,arr,x,y);
            }
        }
    }
}
