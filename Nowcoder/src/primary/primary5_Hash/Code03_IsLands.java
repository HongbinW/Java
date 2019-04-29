package primary.primary5_Hash;

/**
 * @Author: HongbinW
 * @Date: 2019/4/29 15:38
 * @Version 1.0
 * @Description: 题目5
 */
public class Code03_IsLands {
    public static int countLands(int[][] arr){
        if(arr == null)
            return 0;
        int row = arr.length;
        int col = arr[0].length;
        int res = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(arr[i][j] == 1){
                    infect(arr,i,j,row,col);
                    res ++;
                }
            }
        }
        return res;
    }

    public static void infect(int[][] arr,int i , int j, int row, int col){
        if(i < 0 || i >= row || j < 0 ||  j >= col || arr[i][j] != 1)
            return;
        arr[i][j] = 2;
        infect(arr,i-1,j,row,col);
        infect(arr,i+1,j,row,col);
        infect(arr,i,j-1,row,col);
        infect(arr,i,j+1,row,col);
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countLands(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countLands(m2));

    }
}
