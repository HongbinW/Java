public class Solution{
    public static void main(String[] args) {
        System.out.println(maxSum(new  int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSum(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int max = arr[0];
        int res = max;
        for (int i = 1; i < arr.length; i ++){
            if (max + arr[i] >= arr[i]){
                max += arr[i];
            }else{
                max = arr[i];
            }
            res = Math.max(res,max);
        }
        return res;
    }
}