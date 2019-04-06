package sort;

/**
 * @Author: HongbinW
 * @Date: 2019/4/5 16:25
 * @Version 1.0
 * @Description: 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
 * 而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class Q1_215_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        heapInsert(nums);
        int count = 0;
        while(count < k-1){
            swap(nums,0,nums.length-1-count);
            heapify(nums,0,nums.length-2-count);
                count ++;
            }
        return nums[0];
    }
    private static void heapInsert(int[] nums){
        for(int i = 0; i < nums.length; i++){
            while(nums[i] > nums[(i-1)/2]) {
                swap(nums, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void heapify(int[] nums,int start,int end){
        int i = 0;
        while(2*i+1<=end){
            int max = 2 * i + 2 < end && nums[2*i+1] < nums[2*i+2] ? 2*i+2 : 2*i+1;
            int larget = nums[i] > nums[max] ? i : max;
            if(larget == i)
                break;
            swap(nums,i,max);
            i = max;
        }
    }
    //应用快排来找Kth
    public int findKthLargest2(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);      //将l-h部分进行快排
            if (j == k) {                       //找到第k大的数了，不再继续排序
                break;
            } else if (j < k) {                 //当前返回的枢轴（相等的部分的坐标），如果比k小，说明要找的数在枢轴右侧
                l = j + 1;
            } else {                            //如果比k大，说明要找的数在枢轴左侧，即把左侧排序，而此时相当于已经找到了第nums.length-j大的数了
                h = j - 1;
            }
        }
        return nums[k];
    }
        //快排融合了二分法的思想，而此处是进一步的改进，因为要找第k大的数，所以一直nums.length-k比较返回的枢轴的位置
        //实际只是将包含nums.length-k的部分排序，而一旦找到该位置，就停止
    private int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        int com = a[l+(int)(Math.random()) * (h-l+1)];
        while (true) {
            while (a[++i] < com && i < h) ;
            while (a[--j] > com && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);      //交换后，较大的放在右边，较小的放在左边
        }
        swap(a, l, j);          //跳出循环前的最后一次交换，j被换成比当前比较数更小的那个数，所以应该是拿j来跟比较数交换
        return j;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(new Q1_215_findKthLargest().findKthLargest2(nums,k));
    }
}
