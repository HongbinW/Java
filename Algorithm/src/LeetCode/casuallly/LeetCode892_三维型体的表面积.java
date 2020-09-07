package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/3/25
 */
public class LeetCode892_三维型体的表面积 {
    class Solution {
        public int surfaceArea(int[][] grid) {
            int res = 0;
            for(int i = 0; i < grid.length; i ++){
                for(int j = 0; j < grid[0].length; j ++){
                    if(grid[i][j] != 0){
                        int singleDiff = (grid[i][j] - 1) * 2;
                        res += 6 * grid[i][j] - singleDiff;
                        res -= diffArea(grid,i,j);
                    }
                }
            }
            return res;
        }
        public int diffArea(int[][] grid, int i, int j){
            int res = 0;
            res += i - 1 >= 0 ? grid[i-1][j] != 0 ? 2 * Math.min(grid[i-1][j] , grid[i][j]) : 0 : 0;
            res += j - 1 >= 0 ? grid[i][j-1] != 0 ? 2 * Math.min(grid[i][j-1] , grid[i][j]) : 0 : 0;
            return res;
        }
    }
}
