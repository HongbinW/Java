package primary;
//桶排序
public class Code10_MaxGap {
    public static int maxGap(int[] nums){
        if(nums == null || nums.length < 2){
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;    //系统最大
        int max = Integer.MIN_VALUE;    //系统最小
        for(int i = 0; i < len; i++){   //目的是为了找数组中的最小值和最大值
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        if(min == max){
            return 0;
        }
        boolean[] hasNums = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for(int i = 0; i < len; i++){
            bid = bucket(nums[i],len,min,max);  //当前数属于几号桶
            mins[bid] = hasNums[bid] ? Math.min(mins[bid],nums[i]) : nums[i];
            maxs[bid] = hasNums[bid] ? Math.max(maxs[bid],nums[i]) : nums[i];
            hasNums[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 0;
        for(; i <= len; i++){
            if(hasNums[i]){
                res = Math.max(res,mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max){
        return (int) ((num - min) * len / (max - min)); //len就是N号桶
    }
}
