package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/20
 */
public class LeetCode48_rotate_旋转矩阵 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}
        };
        rotate(matrix);
        System.out.println();
    }
    public static void rotate(int[][] matrix) {    // n * n
        int start = 0;
        int end = matrix.length - 1;
        while (start < end){
            for (int i = 0; i < end - start; i ++){
                int tmp = matrix[start][start+i];
                matrix[start][start+i] = matrix[end-i][start];
                matrix[end-i][start] = matrix[end][end-i];
                matrix[end][end-i] = matrix[start+i][end];
                matrix[start+i][end] = tmp;
            }
            start ++;
            end --;
        }
    }
}
