package dynamic_programming_GK;

import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2019/4/9 21:06
 * @Version 1.0
 * @Description: LeetCode120
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class Code04_minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(triangle.size()-1).size();
        int[][] DP = new int[row][col];
        for(int i = 0; i < col; i++){
            DP[row-1][i] = triangle.get(row-1).get(i);
        }
        for(int i = row - 2; i >= 0; i--){
            for(int j = 0;j < triangle.get(i).size(); j++){
                DP[i][j] = Math.min(DP[i+1][j],DP[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return DP[0][0];
    }

}
