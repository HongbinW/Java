package primary;

public class Code06_NetherlandsFlag {
    public static int[] partition(int[] arr, int L,int R, int num){
        if(arr == null || arr.length < 2)
            return null;
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while(cur < more){
            if(arr[cur] < num){
                swap(arr,cur++,++less);
            }
            else if(arr[cur] > num){
                swap(arr,cur,--more);   //换过来的值不知道大小，所以重新比较
            }
            else {
                cur++;
            }
        }
        return new int[] { less + 1, more - 1 };
    }

    public static void swap(int[] arr, int x ,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
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

    public static void main(String[] args) {
//      int[] test = new Code06_NetherlandsFlag().generateArray();    //若generateArray是非static方法，则需要实例化后调用方法
        int[] test =generateArray();
        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 5);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
