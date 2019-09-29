package examination.ByteDance.ym;

/**
 * @Author: HongbinW
 * @Date: 2019/9/17 15:47
 * @Version 1.0
 * @Description:
 */
public class maxSubArrayMinMultiSum {
    public static int maxMinSum(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int res = 0;
        for (int i = 0;i < arr.length; i ++){
            int curSum = arr[i];
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && arr[left] >= arr[i]){
                curSum += arr[left];
                left --;
            }
            while (right < arr.length && arr[right] >= arr[i]){
                curSum += arr[right];
                right ++;
            }
            res = Math.max(res,curSum * arr[i]);
        }
        return res;
    }
}
