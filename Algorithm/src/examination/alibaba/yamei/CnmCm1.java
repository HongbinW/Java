package examination.alibaba.yamei;

import java.util.Scanner;

public class CnmCm1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in );
//        while(sc.hasNextLine()){
//            int n = Integer.parseInt(sc.nextLine());
//            int res = 0;
//            int k = 1;
//            int len = n / 2 + 1;
//            int[] arr = new int[len];
//            int index = 0;
//            while(k <= n){
//                if (k < n / 2) {
//                    arr[index++] = getKfromN(n, k);
//                }
//                res += (arr[k%len+1] * k) % 1000000007;
//                k++;
//            }
//            System.out.println(res% 1000000007);
//        }
        // Cni * Ci1 求和 = n * 2 ^(n-1)
        // n * 2 ^(n-1)
        System.out.println(myPow(7));
    }

    //快速二乘法，不会溢出
    public static long myPow(long n){
        if (n == 0)
            return 1;
        if (n == 1)
            return 2;
        long temp = myPow(n / 2);
        temp = (temp * temp) % 100000007;
        if (n % 2 == 1){
            temp = (2 * temp) % 100000007;
        }
        return temp;
    }
}
