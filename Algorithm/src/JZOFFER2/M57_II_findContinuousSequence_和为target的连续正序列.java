package JZOFFER2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/19
 */
public class M57_II_findContinuousSequence_和为target的连续正序列 {
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;    //双指针，一起往右走，小了right+,大了left+
        ArrayList<int[]> list = new ArrayList<>();
        while (left <= target/2){
            if (sum < target) {
                sum += right;
                right++;
            }else if (sum > target){
                sum -= left;
                left ++;
            }else{
                int[] tmp = new int[right-left+1];
                for (int i = left; i <= right; i ++){
                    tmp[i-left] = i;
                }
                list.add(tmp);
                sum -= left;
                left ++;
            }
        }
        return list.toArray(new int[list.size()][]);

    }
}
