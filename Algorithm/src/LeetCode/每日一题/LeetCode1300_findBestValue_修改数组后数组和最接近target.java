package LeetCode.每日一题;

import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/14
 */
public class LeetCode1300_findBestValue_修改数组后数组和最接近target {
    public static void main(String[] args) {
        System.out.println(findBestValue(new int[]{1547,83230,57084,93444,70879},
        71237));
    }

    public static int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i ++){
            int average = Math.round((float)target / (float)(arr.length - i));
            if (average *(arr.length-i) - target == target - (average-1) * (arr.length-i)){
                average = average - 1;
            }
            if (average < arr[i]){
                return average;
            }else{
                target -= arr[i];
            }
        }
        return arr[arr.length-1];
    }
}
