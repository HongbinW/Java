package LeetCode.explore_byteDance.ArrayAndSort;

import java.util.PriorityQueue;

public class Q5_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return 0;
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = partition(nums,left,right);
            if (nums.length-mid > k){
                left = mid + 1;
            }else if (nums.length-mid < k){
                right = mid - 1;
            }else{
                return nums[mid];
            }
        }
        return -1;
    }

    private int partition(int[] arr, int left, int right){
        int less = left;
        int more = right;
        int index = left;
        while (index < more){
            if (arr[index] < arr[right]){
                swap(arr,index++,less++);
            }else if (arr[index] > arr[right]){
                swap(arr,index,--more);
            }else{
                index ++;
            }
        }
        swap(arr,more,right);
        return more;
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Q5_findKthLargest().findKthLargest2(new int[]{7,6,5,4,3,2,1},2));
    }

    //法二
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0 ; i < nums.length; i ++){
            queue.offer(nums[i]);
            if (queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    //法三
    public int findKthLargest3(int[] nums, int k) {
        for (int i = (k - 1) / 2; i >= 0; i--) {
            heapify(nums, i, k);
        }

        for (int i = k; i < nums.length; ++i) {
            if (nums[i] > nums[0]) {
                nums[0] = nums[i];
                heapify(nums, 0, k);
            }
        }
        return nums[0];
    }
    private void heapify(int[] nums, int i, int k) {
        int smallestIndex = i;
        int leftIndex = (i << 1) + 1;
        int rightIndex = (i << 1) + 2;
        if (leftIndex < k && nums[leftIndex] < nums[smallestIndex]) {
            smallestIndex = leftIndex;
        }
        if (rightIndex < k && nums[rightIndex] < nums[smallestIndex]) {
            smallestIndex = rightIndex;
        }
        if (smallestIndex != i) {
            int tmp = nums[i];
            nums[i] = nums[smallestIndex];
            nums[smallestIndex] = tmp;
            heapify(nums, smallestIndex, k);
        }
    }
}
