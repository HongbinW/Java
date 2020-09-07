package Zuo100.c13;

/**
 * Description
 * Author  HongbinW
 * Date 2019/11/16
 */
public class kth_求两有序数组的第k小的数 {
    public int getKth(int[] arr1, int[] arr2, int k){
        if (arr1 == null && arr2.length < k || arr2 == null && arr1.length < k || arr1 == null && arr2 == null ||
                arr1.length + arr2.length < k || k <= 0){
            return -1;
        }
        int[] longs = arr1.length >= arr2.length ? arr1 : arr2;
        int[] shorts = longs == arr1 ? arr2 : arr1;
        if (k <= shorts.length){
            return midNum(shorts,0,k-1,longs,0,k-1);
        }else if (k > longs.length){
            if (shorts[k - 1 - longs.length] > longs[longs.length-1]){
                return shorts[k-1-longs.length];
            }else if (longs[k -1- shorts.length] > shorts[shorts.length-1]){
                return longs[k -1 - shorts.length];
            }else {
                return midNum(shorts,k - longs.length+1,shorts.length-1,longs,k-shorts.length+1,longs.length-1);
            }
        }else {
            if (longs[k - shorts.length] > shorts[shorts.length-1]){
                return longs[k-shorts.length];
            }else{
                return midNum(shorts,0,shorts.length-1,longs,k-shorts.length+1,k-1);
            }
        }

    }
    public int midNum(int[] arr1, int start1, int end1, int[] arr2, int start2, int end2){
            while (start1 < end1){
            int mid1 = (start1 + end1) / 2;
            int mid2 = (start2 + end2) / 2;
            int offset = (end1 - start1) & 1;
            if (arr1[mid1] > arr2[mid2]){
                end1 = mid1;
                start2 = mid2 + offset;
            }else if(arr1[mid1] == arr2[mid2]){
                return arr1[mid1];
            }else{
                start1 = mid1 + offset;
                end2 = mid2;
            }
        }
        return Math.min(arr1[start1],arr2[start2]);
    }

    public static void main(String[] args) {
        System.out.println(new kth_求两有序数组的第k小的数().getKth(
                new int[]{1,2,3,4,5,6,7,8,9,10},new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17},15));
    }
}
