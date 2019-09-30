package Zuo100.c4;

/**
 * @Author: HongbinW
 * @Date: 2019/9/29 16:10
 * @Version 1.0
 * @Description:
 */
public class Q3_twoMaxSubArraySum_不相交子数组最大和 {
    public static int twoMaxSubArraySum(int[] arr){
        int[] help2 = new int[arr.length];
        int cur = arr[arr.length-1];
        int max = cur;
        for (int i = arr.length - 1; i >= 0; i --){
            if (i == arr.length - 1){
                help2[i] = arr[i];
            }else if (cur + arr[i] > arr[i]){
                cur += arr[i];
            }else{
                cur = arr[i];
            }
            max = Math.max(cur,max);
            help2[i] = max;
        }
        int res = help2[0];
        cur = arr[0];
        max = cur;
        for (int i = 0; i < arr.length; i ++){      //可以少算一个从左往右算的，因为都得过一遍，所以没必要提前算
            if (cur + arr[i] > arr[i]){
                cur += arr[i];
            }else{
                cur = arr[i];
            }
            max = Math.max(cur,max);
            res = Math.max(res,max + (i == arr.length - 1 ? 0 : help2[i + 1]));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(twoMaxSubArraySum(new int[]{-1,3,4,-9,1,2}));
    }
}
