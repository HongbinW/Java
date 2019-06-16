package JZOffer.J_knowledgeTransfer;

import java.util.ArrayList;

public class M57_Q1_FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        if (array == null || array.length < 2){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = array.length-1;       //找两端的两个数，因为是排好序的，所有当两个和小的时候，左边往右移动，两个和大的时候，右边往左边移动
        while (left < right){
            if(array[left] + array[right] > sum){
                right--;
            }else if(array[left] + array[right] < sum){
                left ++;
            }else{
                list.add(array[left]);
                list.add(array[right]);
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new M57_Q1_FindNumbersWithSum().FindNumbersWithSum(new int[]{1,2,4,7,11,15},15);
    }
}
