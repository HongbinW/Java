package dynamic_programming;

/**
 * @Author: HongbinW
 * @Date: 2019/4/9 20:38
 * @Version 1.0
 * @Description: 见印象笔记Java.算法.贪心&动态规划.例二
 */
public class Code02_AllPaths {
    public static int countPaths(boolean[][] grid){
        int row = grid.length - 1;
        int col = grid[0].length - 1;
        int[][] matrix = new int[row+1][col+1];
        matrix[row][col] = 1;
        for(int i = row; i >= 0; i--){
            for(int j = col; j >= 0; j--){
                if(i == j && i == row)
                    continue;
                if(!grid[i][j]){    //空地
                    matrix[i][j] = (i + 1 <= row ? matrix[i+1][j] : 0) +
                            (j + 1 <= col ? matrix[i][j+1] : 0);
                }else{
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix[0][0];
    }

    public static void main(String[] args) {
        boolean[][] grid = new boolean[8][8];
        grid[1][2] = true;grid[1][6] = true;
        grid[2][4] = true;
        grid[3][0] = true;grid[3][2] = true;grid[3][5] = true;
        grid[4][2] = true;
        grid[5][3] = true;grid[5][4] = true;grid[5][6] = true;
        grid[6][1] = true; grid[6][5] = true;
        System.out.println(countPaths(grid));
    }
}
