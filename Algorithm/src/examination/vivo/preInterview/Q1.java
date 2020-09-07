package examination.vivo.preInterview;

import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/7
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i ++){
            arr[i] = sc.nextInt();
            if (arr[i] == 1){
            }
        }
        if (N == 1){
            if (arr[0] == 1){
                System.out.println(0);
            }else{
                System.out.println(1);
            }
        }else
            System.out.println(process(arr));
    }
    public static int process(int[] arr){
        int res = 0;
        for (int i = 0; i < arr.length; i ++){
            if (arr[i] == 1){
                continue;
            }else if (i == 0 && arr[i+1] == 0){
                res ++;
                arr[i] = 1;
            }else if (i == arr.length-1 && arr[i-1] == 0){
                res ++;
                arr[i] = 1;
            }else if (arr[i-1] == 0 && arr[i+1] == 0){
                res ++;
                arr[i] = 1;
            }
        }
        return res;
    }
}
