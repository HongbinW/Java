package nowcode.byteDance.春招2019;

import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/29
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        double tmp = 0;
        for (int i = 0; i < N; i ++){
            tmp += sc.nextInt() * Math.pow(2,N-1-i);
        }
        System.out.println((int)Math.ceil(tmp / Math.pow(2,N)));
    }
}
