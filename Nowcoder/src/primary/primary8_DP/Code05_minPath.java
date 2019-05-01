package primary.primary8_DP;

/**
 * @Author: HongbinW
 * @Date: 2019/4/30 19:32
 * @Version 1.0
 * @Description:
 */
public class Code05_minPath {
    public static int minPath1(int[][] matrix){
        return process1(matrix,matrix.length-1,matrix[0].length-1);
    }

    //从(i,j)出发，到达最右下角位置的最短路径和
    public static int process1(int[][]matrix, int i, int j){
        if(i == matrix.length - 1 && j == matrix[0].length - 1){
            return matrix[i][j];
        }
        //已到达最后一行
        if(i == matrix.length - 1){
            return matrix[i][j] + process1(matrix,i,j+1);
        }
        //已到达最后一列
        if(j == matrix[0].length - 1){
            return matrix[i][j] + process1(matrix,i+1,j);
        }
        return matrix[i][j] + Math.min(process1(matrix,i+1,j),process1(matrix,i,j+1));
    }



}
