package nowcode.byteDance.春招2019;

import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/29
 */
public class Main2_有限距离内安排三人位置 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println(process(arr,D));
    }
    public static int process(int[] arr, int D){
        int left = 0, right = 2;
        long cnt = 0;
        while (right < arr.length) {
            if (arr[right] - arr[left] > D) left++;
            else if (right - left < 2) right++;
            else {
                cnt += Cn3(right - left);
                right++;
            }
        }
        cnt %= 99997867;
        return (int)cnt;
    }
    public static int Cn3(int n){
        return ((n * (n - 1)) % 99997867) / 2;      // 固定首位一人，然后从剩下位置选2人
    }
}
