package examination.pdd;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/2
 */
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        if(K == 0){
            System.out.println("paradox");
        }
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i ++){
            arr[i] = sc.nextInt();
        }
        int cur = 0;
        int i = 0;
        int count = 0;
        for (; i < N; i ++){
            cur += arr[i];
            if (cur == K){
                break;
            }else if (cur > K){
                count ++;
                cur = K - (cur - K);
            }
        }
        if (i < N){
            System.out.println("paradox");
        }else{
            System.out.printf("%d %d\n", K - cur, count);
        }
    }
}
