package JZOFFER2;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/27
 */
public class Q11_minArray_旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (numbers[mid] == numbers[right]){
                right --;
            }else if (numbers[mid] > numbers[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return numbers[left];
    }
}
