package LeetCode.explore_byteDance.ArrayAndSort;

public class Q4_findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int t1 = 1;
        int t2 = 1;
        for(int i = 1 ; i < nums.length; i ++){
            if(nums[i] > nums[i-1]){
                t1++;
            }else{
                t2 = Math.max(t1,t2);
                t1 = 1;
            }
        }
        return Math.max(t1,t2);
    }

    public static void main(String[] args) {
        System.out.println(new Q4_findLengthOfLCIS().findLengthOfLCIS(new int[]{1,3,5,7}));
    }
}
