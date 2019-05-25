package examination.ByteDance.SummerCamp;

import java.util.Scanner;
//岛屿问题。上下左右和斜对角线都算作一个岛屿。
//比如
//0 1 0
//1 0 0
//1 0 1
//则结果时2
public class Main2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            if(str.equals(""))
                break;
            String[] strs = str.split(" ");
            if(strs.length < 2)
                continue;
            try{
                int rows = Integer.parseInt(strs[0]);
                int cols = Integer.parseInt(strs[1]);
            if(rows < 0 || cols < 0)
                continue;
            int[][] arr = new int[rows][cols];
            for(int i = 0 ;i < rows; i++){
                for(int j = 0; j < cols; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int res = 0;
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    if(arr[i][j] == 1){
                        infect(arr,i,j,rows,cols);
                        res++;
                    }
                }
            }
            System.out.println(res);
            }catch(Exception e){
                continue;
            }
        }
    }
    public static void infect(int[][] arr,int i, int j, int rows, int cols){
        if(i < 0 || i >= rows || j < 0 || j >= cols || arr[i][j] != 1)
            return;
        arr[i][j] = 2;
        infect(arr,i-1,j,rows,cols);
        infect(arr,i+1,j,rows,cols);
        infect(arr,i,j-1,rows,cols);
        infect(arr,i,j+1,rows,cols);
        infect(arr,i-1,j-1,rows,cols);
        infect(arr,i+1,j-1,rows,cols);
        infect(arr,i-1,j+1,rows,cols);
        infect(arr,i+1,j+1,rows,cols);
    }
}
