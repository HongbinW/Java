package LeetCode.classify.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/13
 */

/**
 *       如果数字呈\趋势，则表示这已经是最大的了，否则应改成△趋势
 * 思路：数字呈△趋势，即先增加后减小。因此从后往前找到第一个变小的数，索引为i，
 * 然后再从后往前再找到第一个比arr[i]大的数，
 * 把这两个数交换，然后把从i+1至arr.length()-1的数进行从小到大排序即可。
 */
public class LeetCode556_nextGreaterElement_下一个更大的元素 {
    public int nextGreaterElement(int n) {
        int[] arr = new int[32];
        int index = 31;
        while (n > 0){
            arr[index--] = n % 10;
            n /= 10;
        }
        int target = 30;    //从十位开始，找到第一个比后一个数小的数
        while (target > index){
            if (target > 0 && arr[target] < arr[target+1]){
                break;
            }
            target --;
        }
        if (target == index){
            return -1;
        }
        int right = 31;
        while (right > target){
            if (arr[right] > arr[target]){
                break;
            }
            right --;
        }
        int tmp = arr[target];
        arr[target] = arr[right];
        arr[right] = tmp;
        Arrays.sort(arr,target+1,arr.length);
        long res = 0;
        for (int i = index + 1; i < arr.length; i ++){
            res = res * 10 + arr[i];

        }
        return res > Integer.MAX_VALUE ? -1 : (int)res;
    }
public static void main(String[] args) {
    LeetCode556_nextGreaterElement_下一个更大的元素 test = new LeetCode556_nextGreaterElement_下一个更大的元素();
    System.out.println(test.nextGreaterElement(54123));
//    long num = (long)1000000000 * 9;

}
}
