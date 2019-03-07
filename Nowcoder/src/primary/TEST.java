package primary;

import org.junit.Test;

import java.util.Arrays;
class Solution {
    public int JumpFloorII(int target) {
        if(target < 1)
            return 0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        int[] arr = new int[target];
        arr[0] = 1;
        arr[1] = 2;
        for(int i = 2; i < target; i ++){
            for(int j = 0; j < i; j++){
                arr[i] += arr[j];
            }
            arr[i] ++;
        }
        return arr[target - 1];
    }
}
public class TEST {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.JumpFloorII(3));
    }
}











//暴力排序？但似乎比冒泡和选择快
//for (int i = arr.length - 1; i >= 0; i--) {
//        for (int j = 0; j < i ; j++) {
//        if (arr[i] < arr[j])
//        swap(arr, i, j);
//        }
//        }
