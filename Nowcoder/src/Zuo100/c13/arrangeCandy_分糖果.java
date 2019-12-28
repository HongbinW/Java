package Zuo100.c13;

import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2019/11/14
 */
public class arrangeCandy_分糖果 {
    //基础
    public static int arrangeCandy(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int[] help = new int[arr.length];
        Arrays.fill(help,1);
        for (int i = 1; i < arr.length; i ++){
            if (arr[i] > arr[i-1]){
                help[i] = help[i-1] + 1;
            }
        }
        int res = help[arr.length-1];
        for (int i = arr.length - 2; i >= 0; i --){
            if (arr[i] > arr[i+1] && help[i] <= help[i+1]){
                help[i] = help[i+1] + 1;
            }
            res += help[i];
        }
        return res;
    }
    //时间O(N)，空间O(1)
    public static int arrangeCandy2(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int res = 1;
        int i = 1;
        int preMax = 1;
        while (i < arr.length) {
            int cur;
            if (arr[i] > arr[i-1]){     //上升时，起步已经是1了，当前位置应当是2，最后因多算了下降的1，因此减掉
                cur = 1;
                while (i < arr.length && arr[i] > arr[i-1]){
                    cur ++;
                    i ++;
                }
                res += equalDiffSum(cur) - 1;
                preMax = cur;
            }else{
                cur = 0;            //下降时，起步位置为0，且最后不用-1
                while (i < arr.length && arr[i] < arr[i-1]){
                    cur ++;
                    i ++;
                }
                res += equalDiffSum(cur);
                if (preMax < cur){
                    res += cur - preMax + 1;
                }
            }
        }
        return res;
    }
    public static int equalDiffSum(int n){
        return n * (n+1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(new arrangeCandy_分糖果().arrangeCandy(new int[]{1,2,3,4,3,2,1,-1,-2,2,3,4,2,1}));
        System.out.println(new arrangeCandy_分糖果().arrangeCandy2(new int[]{1,2,3,4,3,2,1,-1,-2,2,3,4,2,1}));
        System.out.println(new arrangeCandy_分糖果().arrangeCandy3(new int[]{1,2,3,4,4,4,3,2,2,2,3,3,1}));
    }

    //进阶：如果孩子得分一样，则要求糖果数相同
    public int arrangeCandy3(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int res = 1;
        int i = 1;
        int preMax = 1;
        while (i < arr.length) {
            int cur;
            if (arr[i] > arr[i-1]){     //上升时，起步已经是1了，当前位置应当是2，最后因多算了下降的1，因此减掉
                cur = 1;
                while (i < arr.length && arr[i] > arr[i-1]){
                    cur ++;
                    i ++;
                }
                res += equalDiffSum(cur) - 1;
                while (i < arr.length && arr[i] == arr[i-1]){
                    res += cur;
                    i ++;
                }
                preMax = cur;
            }else{
                cur = 0;            //下降时，起步位置为0，且最后不用-1
                while (i < arr.length && arr[i] < arr[i-1]){
                    cur ++;
                    i ++;
                }
                res += equalDiffSum(cur);
                while (i < arr.length && arr[i] == arr[i-1]){
                    res += 1;
                    i ++;
                }
                if (cur > preMax){
                    res += cur - preMax + 1;    //如果下坡比上坡久，则更新之前坡顶
                }
            }
        }
        return res;
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
    public static void printArray(int[] arr){
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

//    //for test
//    //大样本测试
//    public static void main(String[] args){
//        int testTime = 500000;
//        int size = 10;
//        int value = 100;
//        boolean succeed = true;
//        for (int i = 0;i < testTime; i++){
//            int[] arr1 = generateRandomArray(size,value);
//            int[] arr2 = copyArray(arr1);
//            int[] arr3 = copyArray(arr1);
//            int t1 = arrangeCandy(arr1);
//            int t2 = arrangeCandy(arr2);
//            if(t1 != t2){
//                succeed = false;
//                printArray(arr3);   //看究竟是哪个样本错了
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//    }

}
