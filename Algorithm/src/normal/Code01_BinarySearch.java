package normal;

/**
 * @Author: HongbinW
 * @Date: 2019/3/16 11:04
 * @Version 1.0
 */
public class Code01_BinarySearch {
    public static int BinarySearch(int[] arr, int target){
        int L = 0;
        int R = arr.length;
        while(L <= R){
            int mid = L + (R - L) / 2;
            if(target > arr[mid]){
                L = mid + 1;
            }else if(target < arr[mid]){
                R = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static int BinarySearch_DG(int[] arr,int target){
        return BinarySearch_DG(arr,target,0,arr.length-1);
    }
    private static int BinarySearch_DG(int[] arr,int target,int L,int R){
        if(L > R){
            return -1;
        }
        int mid = L + (R - L) / 2;
        if(target > arr[mid])
            return BinarySearch_DG(arr,target,mid+1,R);
        else if (target < arr[mid])
            return BinarySearch_DG(arr,target,L,mid-1);
        else
            return mid;
    }
}

