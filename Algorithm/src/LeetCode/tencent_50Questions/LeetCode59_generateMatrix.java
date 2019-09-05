package LeetCode.tencent_50Questions;

/**
 * @Author: HongbinW
 * @Date: 2019/9/3 12:05
 * @Version 1.0
 * @Description:
 */
public class LeetCode59_generateMatrix {
    int index = 1;
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int sR = 0, sC = 0, eR = matrix.length - 1, eC = matrix[0].length - 1;
        while (sR <= eR && sC <= eC){
            process(matrix,sR,sC,eR,eC);
            sR ++;
            sC ++;
            eR --;
            eC --;
        }
        return matrix;
    }
    private void process(int[][] matrix, int startRow, int startCol, int endRow, int endCol ){
        if (startRow == endRow){
            matrix[startRow][startCol] = index ++;
        }else {
            for (int i = startCol; i < endCol; i++) {
                matrix[startRow][i] = index++;
            }
            for (int i = startRow; i < endRow; i++) {
                matrix[i][endCol] = index++;
            }
            for (int i = endCol; i > startCol; i--) {
                matrix[endRow][i] = index++;
            }
            for (int i = endRow; i > startRow; i--) {
                matrix[i][startCol] = index++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new LeetCode59_generateMatrix().generateMatrix(3);
        for (int i = 0; i < arr.length; i ++){
            for (int j = 0; j < arr[0].length; j ++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
