package Zuo100.c7;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Description
 * Author  HongbinW
 * Date 2019/11/3
 */
public class Q3_maxCrazy_两两差值最大 {
    public int maxCrazy(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        Arrays.sort(arr);
        LinkedList<Integer> list = new LinkedList<>();
        int left = 0, right = arr.length - 1;
        while (left <= right){
            if (left == right){
                if (Math.abs(arr[left] - list.peekFirst()) > Math.abs(arr[left] - list.peekLast())){
                    list.addFirst(arr[left++]);
                }else{
                    list.addLast(arr[left++]);
                }
            }else {
                if (left % 2 == 0) {
                    list.addFirst(arr[left++]);
                    list.addLast(arr[right--]);
                }else{
                    list.addFirst(arr[right--]);
                    list.addLast(arr[left++]);
                }
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size(); i ++){
            sum += (Math.abs(list.get(i) - list.get(i-1)));
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Q3_maxCrazy_两两差值最大().maxCrazy(new int[]{5,10,25,40,25}));
    }
}
