package primary;
import java.util.Arrays;
public class Code08_HeapSort {

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        for(int i = 0; i < arr.length; i++){
            heapInsert(arr,i);  // 0-i
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize > 0){
            heapipy(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }
    public static void heapInsert(int[] arr,int index){
        while (arr[index] > arr[(index - 1) / 2]){  //如果比父位置大，就交换，直到比父位置小；如果调到0位置，arr[0]=arr[(0-1)/2]
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    public static void swap(int[] arr, int x ,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void heapipy(int[] arr, int index, int heapsize){ //heapsize指要排的堆的长度，不一定是arr.length
        int left = index * 2 + 1;
        while (left < heapsize){
            int largest = left + 1 < heapsize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index)
                break;
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }
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
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }

}
