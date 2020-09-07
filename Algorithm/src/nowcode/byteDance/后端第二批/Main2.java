package nowcode.byteDance.后端第二批;

import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/2
 */
// 颜色，去遍历每一种颜色，超过m个，就break，count+1，然后去遍历下一种颜色
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        int[][] arr = new int[m][c];
        int[] help = new int[c];
        boolean[] valid = new boolean[c];
        for (int i = 0; i < n ; i ++){
            int cur = sc.nextInt();
            if (cur == 0){
                help = new int[c];
                continue;
            }
            for (int j = 0; j < cur; j ++){
                int color = sc.nextInt();
                if (valid[color-1]){
                    continue;
                }
                if (i < m){
                    arr[i][color-1] = 1;
                }
                if (color == 0){
                    help[color-1] = 0;
                }else{
                    help[color-1] ++;
                }
                if (help[color-1] >= m){
                    valid[color-1] = true;
                }
            }
        }
        process(arr,m,c,valid,help);
    }
    public static void process(int[][] arr, int m, int c, boolean[] valid, int[] help){
        for (int i = 0; i < arr.length; i ++){
            for (int j = 0; j < c; j ++){
                if (valid[j]){
                    continue;
                }
                if (arr[i][j] == 0){
                    help[j] = 0;
                }else{
                    help[j] ++;
                    if (help[j] >= m){
                        valid[j] = true;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < c; i ++){
            if (valid[i]){
                res  ++;
            }
        }
        System.out.println(res);

    }
}
