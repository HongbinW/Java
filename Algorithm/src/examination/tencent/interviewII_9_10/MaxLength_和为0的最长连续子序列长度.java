package examination.tencent.interviewII_9_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: HongbinW
 * @Date: 2019/9/11 11:08
 * @Version 1.0
 * @Description:
 */
public class MaxLength_和为0的最长连续子序列长度 {
    //没有OJ，有问题，但不知道在哪
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int curSum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i ++){
            curSum += nums[i];
            if (map.containsKey(curSum - k)){
                maxLen = Math.max(maxLen,i - map.get(curSum-k));
            }else if (!map.containsKey(curSum)){
                map.put(curSum,i);
            }
        }
        return maxLen;
    }

    public static int maxLen(int[] nums, int k){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int maxLen = 0;
        for (int i = 0; i < nums.length; i ++){
            int temp = 0;
            for (int j = i; j < nums.length; j ++){
                temp += nums[j];
                if (temp == k){
                    maxLen = Math.max(maxLen,j - i + 1);
                    if (maxLen == 18){
                        System.out.println("maxLen" + maxLen + " , " + i + " " + j);
                        ArrayList<Integer> list = new ArrayList<>();
                        for (int m = i; m <= j; m ++){
                            list.add(nums[m]);
                        }
                        System.out.println(list);
                    }
                }
            }
        }
        return maxLen;
    }
    public static int maxLengthQ2(int[] arr, int target){
        if (arr == null || arr.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0,-1);      //必须放，详情见笔记[注]  important!!
        int curSum = 0;
        int maxLen = 0;
        for (int i = 0 ; i < arr.length; i ++){
            curSum += arr[i];
            if (map.containsKey(curSum)){
                if (map.containsKey(target - curSum)) {
                    maxLen = Math.max(i - map.get(target - curSum), maxLen);
                }
            }else{
                map.put(curSum,i);
            }
        }
        return maxLen;
    }

//    public static void main(String[] args) {
//        System.out.println(subarraySum(new int[]{1,2,0,0,1,2,0,0,0,1,2,0,0,0,1,1,1}, 3));
//    }
// for test
public static void comparator(int[] arr) {
    Arrays.sort(arr);
}

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 5000;
        int maxSize = 50;
        int maxValue = 50;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr1 = new int[]{-12,-13,-13,-3,-5,10,8,30,10,49,-43,9,1,16,13,17,-1,-27,-18,-8,36,-7,-17,-16,-4,8,24,17,33,-27,-18,4,-40,32,3,23,-36,-13,13,-8,8,1,-4};
//            int k = (int)(maxValue * Math.random());
            int k = 2;
            int x = subarraySum(arr1,k);
            int y = maxLen(arr1,k);

            if (x != y) {
                succeed = false;
                System.out.println(succeed ? "Nice!" : "Fucking fucked!");
                printArray(arr1);
                System.out.println(k);
                System.out.println(x);
                System.out.println(y);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
