package JZOFFER2;

/**
 * Description
 * Author  HongbinW
 * Date 2019/12/14
 */
public class Q53_2_N_1缺失的数字 {
    public static int getMissingNumber(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (arr[mid] == mid){
                left = mid + 1;
            }else if (arr[mid] == mid + 1){
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,2,3,4,5,6,7,8};
        int[] arr2 = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(getMissingNumber(arr));
        System.out.println(getMissingNumber(arr2));
    }
}
