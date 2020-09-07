import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2020/3/22
 */
public class AllSortChallenge {
    public static void bubbleSort(int[] arr){

    }

    public static void insertionSort(int[] arr){

    }

    public static void selectionSort(int[] arr){

    }

    public static void mergeSort(int[] arr){

    }

    public static void quickSort(int[] arr){

    }

    public static void heapSort(int[] arr){

    }

    // for test
    public static void correctAnswer(int[] arr) {
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
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            int[] arr4 = copyArray(arr1);
            int[] arr5 = copyArray(arr1);
            int[] arr6 = copyArray(arr1);
            int[] arr7 = copyArray(arr1);
            bubbleSort(arr2);
            selectionSort(arr3);
            insertionSort(arr4);
            mergeSort(arr5);
            quickSort(arr6);
            heapSort(arr7);
            correctAnswer(arr1);
            if (!isEqual(arr1, arr2) || !isEqual(arr1, arr3) || !isEqual(arr1, arr4) || !isEqual(arr1, arr5) || !isEqual(arr1, arr6) || !isEqual(arr1, arr7)) {
//            if (!isEqual(arr1, arr7)) {
                succeed = false;
                System.out.println("bubbleSort:");
                System.out.println(isEqual(arr1, arr2));
                printArray(arr2);
                System.out.println("selectionSort:");
                System.out.println(isEqual(arr1, arr3));
                printArray(arr3);
                System.out.println("insertionSort:");
                System.out.println(isEqual(arr1, arr4));
                printArray(arr4);
                System.out.println("mergeSort:");
                System.out.println(isEqual(arr1, arr5));
                printArray(arr5);
                System.out.println("quickSort:");
                System.out.println(isEqual(arr1, arr6));
                printArray(arr6);
                System.out.println("heapSort:");
                System.out.println(isEqual(arr1, arr7));
                printArray(arr7);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
