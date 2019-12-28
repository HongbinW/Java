package JZOFFER2;

import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2019/12/14
 */
public class Q53_3_valueEqualIndex_数值和下标相等的元素 {
    public static int valueEqIndex(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] == mid){
                return mid;
            }else if (arr[mid] > mid){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
    //for test
    //随机样本产生器
    public static int[] generateRandomArray(int size,int value){
        //Math.random() -> double [0,1)
        //(int)((size + 1) * Math.random()) -> [0,size]整数

        //生成长度随机的数组（最长就是size）
        int[] arr = new int[(int)((size + 1) * Math.random())];
        for(int i = 0;i < arr.length; i++)
            arr[i] = (int)((value + 1) * Math.random());
        Arrays.sort(arr);
        return arr;
    }

    //for test
    //绝对正确的方法
    public static int rightMethod(int[] arr){
        for (int i = 0; i < arr.length; i ++){
            if (arr[i] == i){
                return i;
            }
        }
        return -1;
    }

    //for test
    public static int[] copyArray(int[] arr){
        if (arr == null){
            return null;
        }
        int[] res = new int[arr.length];
        for(int i = 0;i < arr.length;i++){
            res[i] = arr[i];
        }
        return res;
    }

    //for test
    public static boolean isEqual(int[] arr1, int[] arr2){
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }
        if(arr1 == null && arr2 == null)
            return true;
        if(arr1.length != arr2.length)
            return false;
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    //for test
    public static void printArray(int[] arr){
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //for test
    //大样本测试
    public static void main(String[] args){
        int testTime = 500000;
        int size = 10;
        int value = 10;
        boolean succeed = true;
        for (int i = 0;i < testTime; i++){
            int[] arr1 = generateRandomArray(size,value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            int x = valueEqIndex(arr1);
            int y = rightMethod(arr2);
            if(x != y){
                succeed = false;
                printArray(arr3);   //看究竟是哪个样本错了
                System.out.println(x);
                System.out.println(y);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
