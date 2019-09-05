package goodQuestion.array;

/**
 * @Author: HongbinW
 * @Date: 2019/9/4 11:21
 * @Version 1.0
 * @Description:
 */
public class max_区间和乘区间最小值 {
    public int process(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int res = 0;
        for (int i = 0 ; i < arr.length; i ++){
            int left = i - 1, right = i + 1;
            int sum = arr[i];
            while (left >= 0 && arr[left] >= arr[i]){
                sum += arr[left];
                left --;
            }
            while (right < arr.length && arr[right] >= arr[i]){
                sum += arr[right];
                right ++;
            }
            res = Math.max(res,sum * arr[i]);
        }
        return res;
    }
}
