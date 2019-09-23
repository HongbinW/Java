package examination.ByteDance.ym;

/**
 * @Author: HongbinW
 * @Date: 2019/9/17 16:16
 * @Version 1.0
 * @Description:
 */
public class nextPermutation_下一个排列 {
	//如果一个数组全逆序排列，则该数组已经是最大的了，因此要找a[i] < arr[i+1]，即找到第一个升序的组合
	//此时i就是要动的那个位置，之后再从i到arr.length-1这段区间内找第一个比i大的数，比如i位置是3，则i下一个位置就应该是第一个比3大的数比如是4
	//因为从i+1到arr.length-1这段区间依然是逆序排列，而i位置已经换上了比原来大的最小值，因此后面应该顺序排列。
	//eg: 1 4 6 3 2   ==>第一步找到 4 6 这一对，交换得 1 6 4 3 2，而4 3 2延续之前的逆序，此时要顺序，最终结果为1 6 2 3 4
    public void nextPermutation(int[] arr){
        int i = arr.length-2;
        while (i >= 0 && arr[i] >= arr[i+1]){
            i --;
        }
        if (i >= 0) {
            int j = arr.length - 1;
            while (j > i && arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }
        reverse(arr, i + 1);
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void reverse(int[] arr, int start){
        int end = arr.length-1;
        while (start < end){
            swap(arr,start,end);
            start++;
            end --;
        }
    }
}
