package LeetCode.casuallly;

/**
 * @Author: HongbinW
 * @Date: 2019/9/6 17:41
 * @Version 1.0
 * @Description:
 */
public class LeetCode64_uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] = 1;
        for (int i = obstacleGrid.length - 2; i >= 0; i --){
            if (obstacleGrid[i][obstacleGrid.length-1] != 1){
                obstacleGrid[i][obstacleGrid.length-1] = obstacleGrid[i+1][obstacleGrid.length-1];
            }else{
                obstacleGrid[i][obstacleGrid.length-1] = 0;
            }
        }
        for (int i = obstacleGrid[0].length - 2; i >= 0; i --){
            if (obstacleGrid[obstacleGrid.length-1][i] != 1){
                obstacleGrid[obstacleGrid.length-1][i] = obstacleGrid[obstacleGrid.length-1][i+1];
            }
            else{
                obstacleGrid[obstacleGrid.length-1][i] = 0;
            }
        }
        for (int i = obstacleGrid.length - 2; i >= 0; i --){
            for (int j = obstacleGrid[0].length - 2; j >= 0; j --){
                if (obstacleGrid[i][j] != 1){
                    obstacleGrid[i][j] = obstacleGrid[i][j+1] + obstacleGrid[i+1][j];
                }else{
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[0][0];
    }

    public static void main(String[] args) {

    }
}
