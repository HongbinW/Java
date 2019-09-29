package LeetCode.classify.array;

/**
 * @Author: HongbinW
 * @Date: 2019/9/26 22:05
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/set-matrix-zeroes/
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 */

/**
 * 思路，先记录，再操作
 */
public class LeetCode73_setZeroes_矩阵置零 {
    public void setZeroes(int[][] matrix) {
        // 100% 87%
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[0].length; j ++){
                if (matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < rows.length; i ++){
            if (rows[i]){
                process(matrix,i,-1);
            }
        }
        for (int j = 0; j < cols.length; j ++){
            if (cols[j]){
                process(matrix,-1,j);
            }
        }
    }
    private void process(int[][] matrix, int row, int col){
        if (row != -1) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }
        if (col != -1) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        new LeetCode73_setZeroes_矩阵置零().setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
    }
}
