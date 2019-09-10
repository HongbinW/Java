package LeetCode.casuallly;

import java.util.Objects;

/**
 * @Author: HongbinW
 * @Date: 2019/9/9 22:28
 * @Version 1.0
 * @Description:
 */
public class LeetCode264_nthUglyNumber {
    public static int nthUglyNumber(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        int two = 0, three = 0, five = 0;
        for (int i = 1; i < n; i ++){
            while (two < i && 2 * arr[two] <= arr[i-1]){
                two ++;
            }
            while (three < i && 3 * arr[three] <= arr[i-1]){
                three ++;
            }
            while (five < i && 5 * arr[five] <= arr[i-1]){
                five ++;
            }
            arr[i] = Math.min(2 * arr[two],3*arr[three]);
            arr[i] = Math.min(arr[i],5 * arr[five]);
        }
        return arr[n-1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
