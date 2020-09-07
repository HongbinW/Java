package Zuo100.c2;

/**
 * @Author: HongbinW
 * @Date: 2019/7/28 17:31
 * @Version 1.0
 * @Description:
 */
public class Q2_lessSum_小和 {
    public static int lessSum(int[] arr){
        int left = 0, right = arr.length-1;
        return process(arr,left,right);
    }
    public static int process(int[] arr, int left, int right){
        if (left < right){
            int mid = left + (right - left) / 2;
            return process(arr,left,mid) + process(arr,mid+1,right) + merge(arr,left,right,mid);
        }else {
            return 0;
        }
    }

    public static int merge(int[] arr, int start, int end, int mid){
        int[] help = new int[end-start+1];
        int left = start;
        int right = mid + 1;
        int index = 0;
        int res = 0;
        while (left <= mid && right <= end){
            res += arr[left] < arr[right] ? arr[left] * (end - right + 1) : 0;      //这两行不要颠倒，因为下一行的索引都变了
            help[index++] = arr[left] < arr[right] ? arr[left ++] : arr[right ++];
        }
        while (left <= mid){
            help[index++] = arr[left++];
        }
        while (right <= end){
            help[index++] = arr[right++];
        }
        for (int i = 0 ; i < help.length; i ++){
            arr[start+i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lessSum(new int[]{1,3,5,2,4,6}));
    }
}
