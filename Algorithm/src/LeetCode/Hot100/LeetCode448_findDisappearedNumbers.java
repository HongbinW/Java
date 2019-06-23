package LeetCode.Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2019/6/20 22:45
 * @Version 1.0
 * @Description:
 */
public class LeetCode448_findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[nums.length];
        for (int i = 0 ; i < nums.length; i ++){
            arr[nums[i] - 1] ++;
        }
        for (int i = 0 ; i < nums.length; i++){
            if (arr[i] == 0){
                list.add(i + 1);
            }
        }
        return list;
    }
        //OK   参考JZOFFER3
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list=new ArrayList<>();
        if (nums==null)
            return list;
        for(int i=0;i<nums.length;)
        {
            if (nums[i]==i+1 || nums[i]==nums[nums[i]-1]  )
            {
                i++;
            }else {
                swap(nums,i,nums[i]-1);
            }
        }
        for (int i=0;i<nums.length;i++)
        {
            if (nums[i]!=i+1)
                list.add(i+1);
        }
        return list;
    }

    //
    public List<Integer> findDisappearedNumbers3(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < nums.length; i++){
            nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);       //让nums[i]位置对应的数变成负数
        }
        for (int i = 0 ; i < nums.length; i++){     //这样，就查哪些没变成负数，说明这个位置上的数不存在
            if (nums[i] > 0){
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        LeetCode448_findDisappearedNumbers test = new LeetCode448_findDisappearedNumbers();
        List<Integer> list = test.findDisappearedNumbers3(new int[]{4,3,2,7,8,2,3,1});
        for (int ele : list){
            System.out.print(ele + " ");
        }
    }
}
