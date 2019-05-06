package primary.primarty1;
import java.util.Arrays;
//找到剩下序列中最小元素的索引，然后与当前位置交换
//结束方向：从前往后
//时间复杂度固定，就是O（N²）
public class Code02_SelectionSort {
    public static void SelectionSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        for(int i = 0;i < arr.length;i ++){
            int minIndex = i;
            for(int j = i + 1;j < arr.length;j++){
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }

    }
    public static void swap(int[] arr,int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static int[] generateRandomArray(int size,int value){
        int[] arr = new int[(int)(Math.random() * (size + 1))];
        for(int i = 0; i < arr.length; i++)
            arr[i] = (int)(Math.random() * (value + 1));
        return arr;
    }

    public static void rightMethod(int[] arr){
        Arrays.sort(arr);
    }

    public static boolean isEqual(int[] arr1,int[] arr2){
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if (arr1.length != arr2.length)
            return false;
        if(arr1 == null && arr2 == null)
            return true;
        for(int i = 0;i < arr1.length; i++){
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public static void printArray(int[] arr){
        if(arr == null)
            return;
        for(int i = 0;i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] copyArray(int[] arr){
        if(arr == null)
            return null;
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args){
        int testTimes = 50000;
        int size = 10;
        int value = 20;
        boolean succeed = true;
        for(int i = 0; i < testTimes; i++){
            int[] arr1 = generateRandomArray(size,value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            SelectionSort(arr1);
            rightMethod(arr2);
            if(!isEqual(arr1,arr2)){
                succeed = false;
                printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Fucking fuck!");
    }
}
