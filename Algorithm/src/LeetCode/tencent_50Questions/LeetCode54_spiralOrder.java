package LeetCode.tencent_50Questions;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2019/9/3 11:54
 * @Version 1.0
 * @Description:
 */
public class LeetCode54_spiralOrder {
    List<Integer> list = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        int sR = 0, sC = 0, eR = matrix.length - 1, eC = matrix[0].length - 1;
        while (sR <= eR && sC <= eC){
            process(matrix,sR,sC,eR,eC);
            sR ++;
            sC ++;
            eR --;
            eC --;
        }
        return list;
    }
    public void process(int[][] matrix, int startRow, int startCol, int endRow, int endCol){
        if (startRow == endRow){
            for (int i = startCol; i <= endCol; i ++){
                list.add(matrix[startRow][i]);
            }
        }else if (startCol == endCol){
            for (int i = startRow; i <= endRow; i ++){
                list.add(matrix[i][startCol]);
            }
        }else{
            for (int i = startCol; i < endCol; i ++){
                list.add(matrix[startRow][i]);
            }
            for (int i = startRow; i < endRow; i ++){
                list.add(matrix[i][endCol]);
            }
            for (int i = endCol; i > startCol; i --){
                list.add(matrix[endRow][i]);
            }
            for (int i = endRow; i > startRow; i --){
                list.add(matrix[i][startCol]);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new LeetCode54_spiralOrder().spiralOrder(new int[][]{
                {1,2,3,4,5,6,7,8,9,10}
        });
        for (int i : list){
            System.out.print(i + " ");
        }
    }
}
