package LeetCode.tencent_50Questions;

public class LeetCode215_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int cur = partition(nums,left,right);
            int temp = nums.length - cur;
            if (temp < k){
                right = cur - 1;
            }else if (temp > k){
                left = cur + 1;
            }else{
                return nums[cur];
            }
        }
        return -1;
    }
    private int partition(int[] arr, int left, int right){
        int less = left;
        int more = right;
        while (left < more){
            if (arr[left] > arr[right]){
                swap(arr,left,--more);
            }else if (arr[left] < arr[right]){
                swap(arr,less++,left++);
            }else{
                left ++;
            }
        }
        swap(arr,left,right);
        return left;
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(new LeetCode215_findKthLargest().findKthLargest(arr,4));
    }
}
