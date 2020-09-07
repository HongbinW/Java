package primary.primarty1;

import java.util.Arrays;

//相邻两者比较，选最大的放在最后面
//结束方向：从后往前
//时间复杂度固定，就是O（N²）
public class Code01_BubbleSort {
    public static void BubbleSort(int[] arr){
        if(arr == null || arr.length <2)
            return;
        for(int i = arr.length - 1; i > 0 ;i --){
            for(int j = 0;j < i;j++){
                if(arr[j] > arr[j+1])
                    swap(arr,j,j+1);
            }
        }
    }
    public static void swap(int[] arr ,int x,int y){
        arr[x] = arr[x] ^ arr[y];
        arr[y] = arr[x] ^ arr[y];
        arr[x] = arr[x] ^ arr[y];
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
        return arr;
    }

    //for test
    //绝对正确的方法
    public static void rightMethod(int[] arr){
        Arrays.sort(arr);
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
        int value = 100;
        boolean succeed = true;
        for (int i = 0;i < testTime; i++){
            int[] arr1 = generateRandomArray(size,value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            BubbleSort(arr1);
            rightMethod(arr2);
            if(!isEqual(arr1,arr2)){
                succeed = false;
                printArray(arr3);   //看究竟是哪个样本错了
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
