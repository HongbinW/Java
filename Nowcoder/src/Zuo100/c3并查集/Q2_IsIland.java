package Zuo100.c3并查集;

/**
 * @Author: HongbinW
 * @Date: 2019/8/4 21:41
 * @Version 1.0
 * @Description:
 */
public class Q2_IsIland {
    public static int isLand(int[][] arr){
        int count = 0;
        for (int i = 0 ; i < arr.length; i ++){
            for (int j = 0; j < arr[0].length; j ++){
                if (arr[i][j] != 1){
                    continue;
                }else{
                    process(arr,i,j);
                    count ++;
                }
            }
        }
        return count;
    }
    private static void process(int[][] arr, int i , int j){
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != 1){
            return;
        }
        arr[i][j] = 2;
        process(arr,i+1,j);
        process(arr,i-1,j);
        process(arr,i,j+1);
        process(arr,i,j-1);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0,0,0,0,0},
                {0,1,0,1,0},
                {1,0,1,0,1},
                {1,1,1,1,1}
        };
        System.out.println(isLand(arr));
    }
}
