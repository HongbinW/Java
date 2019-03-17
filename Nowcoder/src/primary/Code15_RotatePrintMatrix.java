package primary;

/**
 * @Author: HongbinW
 * @Date: 2019/3/16 14:53
 * @Version 1.0
 */
public class Code15_RotatePrintMatrix {
    public static void rotate(int[][] matrix){
        int start1 = 0, end1 = 0, start2 = matrix.length-1, end2 = matrix[0].length-1;
        while(true){
            if(start1 > start2 || end1 > end2)
                break;
            rotateEdge(matrix,start1++,end1++,start2--,end2--);
        }
    }
    public static void rotateEdge(int[][] matrix, int start1, int end1, int start2, int end2){
        if(start1 == start2){
            for(int i = end1; i <= end2; i++){
                System.out.println(matrix[start1][i]);
            }
        }else if(end1 == end2){
            for(int i = start1; i <= start2; i++){
                System.out.println(matrix[i][end1]);
            }
        }else {
            for (int i = end1; i < end2; i++) {
                System.out.println(matrix[start1][i]);
            }
            for (int i = start1; i < start2; i++) {
                System.out.println(matrix[i][end2]);
            }
            for (int i = end2; i > end1; i--) {
                System.out.println(matrix[start2][i]);
            }
            for (int i = start2; i > start1; i--) {
                System.out.println(matrix[i][end1]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1},{2},{3},{4},{5}};
        System.out.println(matrix);
        rotate(matrix);
    }
}
