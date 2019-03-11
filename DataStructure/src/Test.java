import java.util.ArrayList;
import java.util.List;

/**
 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
/*
tips:
    正数的补码就是其本身
    负数的补码是在其原码的基础上, 符号位不变, 其余各位取反, 最后+1. (即在反码的基础上+1)

    正数的反码是他原码
    负数的反码是在其原码的基础上, 除了符号位数不变，其余位取反.
 */
public class Test{
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,0,2,5,3};
        System.out.println(duplicate(arr));
    }
    public static ArrayList<Integer> duplicate(int[] arr){
        if(arr == null || arr.length < 2){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            while(arr[i] != i){
                if(arr[i] == arr[arr[i]]){
                    list.add(arr[i]);
                    if(i == arr.length - 1) {
                        break;
                    }
                    i++;
                }else {
                    swap(arr, i, arr[i]);
                }
            }
        }
        return list;
    }
    public static void quickSort(int[] arr,int L, int R){
        if(L < R){
            swap(arr,(int)(Math.random() * (R - L + 1)),R);
            int[] p = partition(arr,L,R);
            partition(arr,L,p[0]);
            partition(arr,p[1],R);
        }
    }
    public static int[] partition(int[] arr,int L ,int R){
        int less = L - 1;
        int more = R;
        while(L < more){
            if(arr[L] < arr[R]){
                swap(arr,L++,++less);
            }else if(arr[L] > arr[R]){
                swap(arr,L,--more);
            }else{
                L++;
            }
        }
        swap(arr,more,R);
        return new int[]{less,more+1};
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}