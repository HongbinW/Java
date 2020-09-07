package Zuo100.c13;

/**
 * Description
 * Author  HongbinW
 * Date 2019/11/15
 */
public class MidNum_两个等长数组找中位数 {
    public static void main(String[] args) {
        System.out.println(midNum(new int[]{1,2,3,4},new int[]{5,6,7,8}));
    }
    public static int midNum(int[] arr1, int[] arr2){
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0){
            return 0;
        }
        int start1 = 0;
        int end1 = arr1.length - 1;
        int start2 = 0;
        int end2 = arr2.length - 1;
        while (start1 < end1){
            int mid1 = start1 + (end1 - start1) / 2;
            int mid2 = start2 + (end2 - start2) / 2;
            int offset = (end1 - start1) & 1;       //当前比较长度，偶数是要+1，奇数多算一个
            // 1 2 3 4
            // 1' 2' 3' 4'
            // 可能的结果是1，2,3',4'
            // 1 2 3 4 5
            // 1' 2' 3' 4' 5'
            // 可能的结果是 1, 2, 3', 4', 5',因为要求是偶数个，所以3也要算上
            if (arr1[mid1] > arr2[mid2]){
                end1 = mid1;
                start2 = mid2 + offset;
            }else if (arr1[mid1] == arr2[mid2]){
                return arr1[mid1];
            }else {
                start1 = mid1 + offset;
                end2 = mid2;
            }
        }
        return Math.min(arr1[start1],arr2[start2]);
    }
}
