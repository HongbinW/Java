import java.util.Scanner;

/**
 * @Author: HongbinW
 * @Date: 2019/4/2 19:58
 * @Version 1.0
 * @Description:
 */
public class Main {
    public static int minNuts(int[] a){
        if(a.length < 5)
            return a[0];
        int[] DP = new int[a.length];
        DP[0] = a[0];
        DP[1] = Integer.MAX_VALUE;
        DP[2] = Integer.MAX_VALUE;
        DP[3] = DP[0] + a[3];
        DP[4] = DP[0] + a[4];
        for(int i = 5; i < a.length; i++){
            DP[i] = getMin(DP[i-3],DP[i-4],DP[i-5]) + a[i];
        }
        int res = getMin(DP[a.length-1],DP[a.length-2],DP[a.length-3]);
        res = getMin(DP[a.length-4],DP[a.length-5],res);
        return res;
    }

    public static int getMin(int i, int j, int k){
        int res = i < j ? i : j;
        return res < k ? res : k;
    }

    public static int[] generateRandomArray(int size,int value){
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; i++)
            arr[i] = (int)(Math.random() * (value + 1)+1);
        return arr;
    }

    public static void printArray(int[] arr){
        if(arr == null)
            return;
        for(int i = 0;i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = generateRandomArray(15,5);
        printArray(arr);
        arr = new int[]{2,1,3,6,5,5,5,5,6,3,1,1,6,6,5};
        System.out.println(minNuts(arr));
    }
}

