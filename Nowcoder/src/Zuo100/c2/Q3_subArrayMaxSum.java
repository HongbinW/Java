package Zuo100.c2;

public class Q3_subArrayMaxSum {

    public static int subArraySum(int[] arr){
        int cur = arr[0];
        for (int i = 1 ; i < arr.length; i ++){
            cur = cur + arr[i] > arr[i] ? cur + arr[i] : arr[i];
            arr[0] = Math.max(arr[0],cur);
        }
        return arr[0];
    }

    public static void main(String[] args) {
        System.out.println(subArraySum(new int[]{1,-2,3,5,-2,6,-1}));
    }
}
