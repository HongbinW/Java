import com.sun.org.apache.regexp.internal.RE;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,2,3,5,8,9,7,4,1,6};
        int k = 3;
        int back = partition(arr,0,arr.length-1);
        while(true){
            if(back == k){
                System.out.println(arr[back]);
                break;
            }else if(back < k){
                back = partition(arr,0,arr.length-1-back);
            }else{
                back = partition(arr,arr.length-back+1,arr.length-1);
            }
        }
    }
    public static int partition(int[] arr, int L, int R){
        int less = L-1;
        int more = R;
        int index = L;
        while(index < more && less < more){
            if(arr[index] > arr[R]){
                swap(arr,index,--more);
            }
            else if(arr[index] < arr[R]){
                swap(arr,++less,index++);
            }else{
                index++;
            }
        }
        swap(arr,index,R);
        return arr.length-index;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}