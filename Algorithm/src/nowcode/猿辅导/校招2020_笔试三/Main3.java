package nowcode.猿辅导.校招2020_笔试三;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/18
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i ++){
            arr[i] = sc.nextInt();
        }
        process(arr,s);
    }
    public static void process(int[] arr, int s){
        int left = 0;
        int right = 0;
        int cur = 0;
        int res = 0;
        while (left <= right && right < arr.length){
            if (cur <= s){
                cur += arr[right ++];
            }else{
                res = Math.max(res,right-left - 1);
                cur -= arr[left++];
            }
        }
        if (cur <= s){
            res = Math.max(res, right - left);
        }
        System.out.println(res);
    }
}
