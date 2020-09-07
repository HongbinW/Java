package JZOFFER2;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/20
 */
public class M21_exchange_奇数位于偶数前 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if ((nums[left] & 0b1) == 1){
                left ++;
                continue;
            }
            if ((nums[right] & 0b1) == 0){
                right --;
                continue;
            }
            swap(nums,left,right);
            left ++;
            right --;
        }
        return nums;
    }
    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
