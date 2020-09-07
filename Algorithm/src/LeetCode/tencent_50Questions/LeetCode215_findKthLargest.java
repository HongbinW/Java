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

    public int findKthLargest2(int[] nums, int k) {
        return process2(nums,nums.length-k,0,nums.length -1);
    }

    public int process2(int[] nums, int k, int left, int right){
        if (left <= right){
            int p[] = partition2(nums,left,right);
            if (p[0] > k){
                return process2(nums,k,left,p[0]-1);
            }else if (p[1] < k){
                return process2(nums,k,p[1]+1,right);
            }else{
                return nums[p[1]];
            }
        }
        return -1;
    }
    public int[] partition2(int[] nums, int left, int right){
        int less = left - 1;
        int more = right;
        while (left < more){
            if (nums[left] > nums[right]){
                swap(nums,left,--more);
            }else if (nums[left] < nums[right]){
                swap(nums,++less, left ++);
            }else{
                left ++;
            }
        }
        swap(nums, right, left);
        return new int[]{less+1,more};
    }
}
