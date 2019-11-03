package Zuo100.c6;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2019/10/30
 */
//N次后的结果。每次在序列后加一个数，逆序
public class Q4_afterN_添加到队尾并反转 {
    public static int[] afterN(){
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int N = sc.nextInt();
            int[] arr = new int[N];
            int left = N / 2 - 1;
            int right = N / 2 + 1;
            arr[N/2] = sc.nextInt();
            for (int i = 0; i < N - 1; i ++){
                if (N % 2 == 0) {
                    if (i % 2 == 0) {
                        arr[left--] = sc.nextInt();
                    } else {
                        arr[right++] = sc.nextInt();
                    }
                }else {
                    if (i % 2 == 0) {
                        arr[right++] = sc.nextInt();
                    } else {
                        arr[left--] = sc.nextInt();
                    }
                }
            }
            return arr;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = afterN();
        for (int i : arr){
            System.out.println(i);
        }
    }
}
