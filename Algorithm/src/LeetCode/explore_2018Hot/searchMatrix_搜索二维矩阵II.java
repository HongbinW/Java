package LeetCode.explore_2018Hot;

/**
 * @Author: HongbinW
 * @Date: 2020/1/1 21:09
 * @Version 1.0
 * @Description:
 */
public class searchMatrix_搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0){
            if (matrix[row][col] == target){
                return true;
            }else if (matrix[row][col] > target){
                col --;
            }else{
                row ++;
            }
        }
        return false;
    }
}
