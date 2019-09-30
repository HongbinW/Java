package Zuo100.c4;

public class Q4_leftRightMaxDiff {
    public static int leftRightMaxDiff(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i ++){
            max = Math.max(max,arr[i]);
        }
        return max - Math.min(arr[0],arr[arr.length-1]);
    }

    public static void main(String[] args) {
        System.out.println(leftRightMaxDiff(new int[]{2,7,3,1,1}));
    }
}
