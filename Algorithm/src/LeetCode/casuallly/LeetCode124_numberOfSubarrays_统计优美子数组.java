package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/4/21
 */
public class LeetCode124_numberOfSubarrays_统计优美子数组 {
    public static void main(String[] args) {
        System.out.println(new LeetCode124_numberOfSubarrays_统计优美子数组().numberOfSubarrays2(new int[]{2,2,2,1,2,2,1,2,2,2},2));
    }
    public int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length < k){
            return 0;
        }
        int[] arr = new int[nums.length+1];
        int size = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] % 2 == 1){
                arr[size++] = i;
            }
        }
        arr[size] = nums.length;
        int pre = -1;
        int res = 0;
        int index = 0;
        while (index+k-1 < size){
            res += (arr[index] - pre) * (arr[index+k] - arr[index+k-1]);
            pre = arr[index];
            index ++;
        }
        return res;
    }

    public int numberOfSubarrays2(int[] nums, int k) {
        int count = 0;
        int [] oddpos = new int[nums.length];
        int odd = 0;
        for(int i = 0; i < nums.length; i++){
            oddpos[odd]++;
            if((nums[i] & 1) ==1){
                odd++;
            }
            if(odd>=k){
                count += oddpos[odd - k];
            }
        }

        return count;
    }
}
