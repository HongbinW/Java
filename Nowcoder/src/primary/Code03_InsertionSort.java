package primary;
import java.util.Arrays;
//每次排0—N（次数）位置上的数，将其从小到大排列，依次比较，N和N-1，N-1和N-2……
//比如像理牌，手上的牌已经从小到大排好，然后新来一张牌，那就从最大的往最小的看能插到哪个位置，因此叫插入排序
//时间复杂度，与数据状况有关系
/*
    比如说，开始顺序是1,2,3,4,5.那么时间复杂度为O（N），因为每到第二轮循环的时候直接结束
    而如果是5,4,3,2,1那么时间复杂度是O（N²）
 */
public class Code03_InsertionSort {
    public static void InSertionSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        for(int i = 1; i < arr.length;i++){
            for(int j = i ; j > 0 && arr[j] < arr[j - 1] ; j--){
                    swap(arr,j,j-1);
            }
        }
    }
    public static void swap(int[] arr,int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static int[] generateRandomArray(int size,int value){
        int[] arr = new int[(int)(Math.random() *  (size + 1))];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * (value + 1));
        }
        return arr;
    }
    public static boolean isEqual(int[] arr1,int[] arr2){
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if(arr1 == null && arr2 == null)
            return true;
        if(arr1.length != arr2.length)
            return false;
        for(int i = 0;i < arr1.length;i++){
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
    public static int[] copyArray(int[] arr){
        if (arr == null)
            return null;
        int[] res = new int[arr.length];
        for(int i = 0; i< arr.length; i++){
            res[i] = arr[i];
        }
        return res;
    }
    public static void printArray(int[] arr){
        if(arr == null)
            return;
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void rightMethod(int[] arr){
        Arrays.sort(arr);
    }
    public static void main(String[] args){
        int testTimes = 50000;
        int size = 10;
        int value = 20;
        boolean succeed = true;
        for(int i = 0;i < testTimes; i++){
            int[] arr1 = generateRandomArray(size,value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            InSertionSort(arr1);
            rightMethod(arr2);
            if(!isEqual(arr1,arr2)){
                succeed = false;
                printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Wrong");
    }
}