package JZOFFER2;

/**
 * Description
 * Author  HongbinW
 * Date 2019/12/14
 */
public class Q53_NumOccurTimesInOrderArray_数字在排序树组中出现的次数 {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){
            return 0;
        }
        int left = 0, right = array.length - 1;
        int mid = left + (right - left) / 2;
        while (left < right){
            if(array[mid] == k){
                break;
            }else if (array[mid] > k){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        if (array[mid] != k){
            return 0;
        }else{
            int num = 1;
            left = mid - 1;
            right = mid + 1;
            while (left >= 0 && array[left] == k){
                num ++;
                left --;
            }
            while (right < array.length && array[right] == k){
                num ++;
                right ++;
            }
            return num;
        }
    }
}
