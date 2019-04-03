package JZOffer.E_DrawToVisualize;

import java.util.ArrayList;

/**
 * @Author: HongbinW
 * @Date: 2019/3/27 11:46
 * @Version 1.0
 * @Description:
 */
public class M29_printMatrix {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start1 = 0 , end1 = 0, start2 = rows-1, end2 = cols-1;
        ArrayList<Integer> list = new ArrayList<>();
        while (start1 <= start2 && end1 <= end2){
            printMatrix(matrix,start1,end1,start2,end2,list);
            start1++;
            end1++;
            start2--;
            end2--;
        }
        return list;
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix,int start1,int end1,int start2,int end2,ArrayList<Integer> list){
        if(start1 == start2){
            while(end1 <= end2)
                list.add(matrix[start1][end1]);
        }else if(end1 == end2){
            while(start1 <= start2)
                list.add(matrix[start1][end1]);
        }else{
            for(int i = end1; i < end2; i++){
                list.add(matrix[start1][i]);
            }
            for(int i = start1; i < start2; i++){
                list.add(matrix[i][end2]);
            }
            for(int i = end2; i > end1; i--){
                list.add(matrix[start2][i]);
            }
            for(int i = start2; i > start1; i--){
                list.add(matrix[i][end1]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(printMatrix(matrix));
    }
}
