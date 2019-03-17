package primary;

/**
 * @Author: HongbinW
 * @Date: 2019/3/16 15:32
 * @Version 1.0
 */
public class Code16_RotateMatrix {
    public static void rotate(int[][] matrix){
        int start1 = 0, end1 = 0;
        int start2 = matrix.length-1;
        int end2 = matrix[0].length-1;
        while(start1 <= start2 || end1 <= end2){
            rotate(matrix,start1++,end1++,start2--,end2--);
        }
    }
    public static void rotate(int[][] matrix, int start1, int end1, int start2, int end2){
        if(start1 == start2 && end1 == end2){
            return;
        }
        int count = start2 - start1;
        for(int i = 0; i < count; i++){
            swap(matrix,start1++,end1++,start2--,end2--,i);
        }
    }
    public static void swap(int[][] matrix, int start1, int end1, int start2, int end2,int i){
        int temp = matrix[start1][end1+i];
        matrix[start1][end1+i] = matrix[start2-i][end1];
        matrix[start2-i][end1] = matrix[start2][end2-i];
        matrix[start2][end2-i] = matrix[start1+i][end2];
        matrix[start1+i][end2] = temp;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.println("111");
    }
}
